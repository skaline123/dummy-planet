/**
 * 
 */
package mx.com.danito.api.sample.planet.facade;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mx.com.danito.api.sample.planet.bean.ProcessBean;
import mx.com.danito.api.sample.planet.util.PlanetConstants;
import mx.com.danito.api.sample.planet.util.Util;
import mx.com.danito.api.sample.planet.vo.DataFilesVO;

/**
 * @author danito
 *
 */
public class PlanetFacade {

	private final static Logger LOGGER = LogManager.getLogger(PlanetFacade.class);

	public void processFileCsv(ProcessBean pmbean) {
		LOGGER.log(Level.INFO, "Init processFileCsv ---");
		try {
			checkDetectFiles(pmbean, PlanetConstants.EXT_FILES_CSV);
			if (pmbean.isValidator()) {
				if (pmbean.getLstFiles() != null && pmbean.getLstFiles().size() > 0) {
					List<String> lines = null;
					for (String file : pmbean.getLstFiles()) {
						lines = Util.readFileInList(PlanetConstants.ROUTE_FILES + file);
						if (lines != null && lines.size() > 0) {
							processFile(pmbean, PlanetConstants.EXT_FILES_CSV, lines);
						}
					}
				}

				// remove files to archive
				moveFilesProccesed(pmbean);

			} else {
				LOGGER.log(Level.INFO, "--- Not exist files with valid extention ---");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		LOGGER.log(Level.INFO, "Finish processFileCsv  ---");
	}

	public void processFileAscii(ProcessBean pmbean) {
		LOGGER.log(Level.INFO, "Init processFileAscii ---");
		try {
			checkDetectFiles(pmbean, PlanetConstants.EXT_FILES_TXT);
			if (pmbean.isValidator()) {
				if (pmbean.getLstFiles() != null && pmbean.getLstFiles().size() > 0) {
					List<String> lines = null;
					for (String file : pmbean.getLstFiles()) {
						lines = Util.readFileInList(PlanetConstants.ROUTE_FILES + file);
						if (lines != null && lines.size() > 0) {
							processFile(pmbean, PlanetConstants.EXT_FILES_TXT, lines);
						}
					}
				}

				// remove files to archive
				moveFilesProccesed(pmbean);
			} else {
				LOGGER.log(Level.INFO, "--- Not exist files with valid extention ---");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		LOGGER.log(Level.INFO, "Finish processFileAscii  ---");
	}

	private void checkDetectFiles(ProcessBean pmbean, final String extention) {
		Util.detectFiles(pmbean, PlanetConstants.ROUTE_FILES, extention);
	}

	private void processFile(ProcessBean pmbean, final String extention, final List<String> lines)
			throws ParseException {
		
		if (lines != null && lines.size() > 0) {
			List<DataFilesVO> lst = new ArrayList<DataFilesVO>();
			for (String row : lines) {
				if (extention.equals(PlanetConstants.EXT_FILES_TXT)) {
					if (checkLengthRow(row, extention)) {

						// setValues rows
						lst.add(setValues(extention, row));

					}
				} else if (extention.equals(PlanetConstants.EXT_FILES_CSV)) {
					if (checkLengthRow(row, extention)) {

						// setValues rows
						lst.add(setValues(extention, row));
					}
				}
			}

			pmbean.setLstRows(lst);
			// order values
			
			DataFilesVO[] lstOrder = orderList(pmbean);

			// write into file output and put the file in output folder
			writeToFile(lstOrder);
			

		}
	}

	private boolean checkLengthRow(final String row, final String extention) {
		if (row != null && !row.isEmpty()) {
			if (extention.equals(PlanetConstants.EXT_FILES_TXT)) {
				if (row.length() == PlanetConstants.LENGTH_ROW_TXT) {
					return true;
				}
			} else if (extention.equals(PlanetConstants.EXT_FILES_CSV)) {
				String[] r = row.split(PlanetConstants.DELIMIT_STRING);
				if (r != null && r.length > 0) {
					if (r.length == 9)
						return true;
				}
			}
		}
		return false;
	}

	private DataFilesVO setValues(final String extention, final String row) throws ParseException {
		DataFilesVO obj = null;
		if (row != null && row.length() > 0) {
			obj = new DataFilesVO();
			if (extention.equals(PlanetConstants.EXT_FILES_TXT)) {
				String[] rowq = selectRowFileAscii(row);
				obj = setValueRow(rowq);
			} else if (extention.equals(PlanetConstants.EXT_FILES_CSV)) {
				String[] rowq = row.split(PlanetConstants.DELIMIT_STRING);
				obj = setValueRow(rowq);
			}
		}
		return obj;

	}

	private DataFilesVO setValueRow(String[] rowq) throws ParseException {
		DataFilesVO obj = new DataFilesVO();
		if (rowq != null && rowq.length > 0) {
			for (int z = 0; z < rowq.length; z++) {
				if (z == 0)
					obj.setFirstName(rowq[z].trim());
				if (z == 1)
					obj.setLastName(rowq[z].trim());
				if (z == 2) {
					obj.setStartDate(rowq[z].trim());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddd");
					obj.setDateStartDate(sdf.parse(rowq[z].trim()));
				}
				if (z == 3)
					obj.setAddressOne(rowq[z].trim());
				if (z == 4)
					obj.setAddressTwo(rowq[z].trim());
				if (z == 5)
					obj.setCity(rowq[z].trim());
				if (z == 6)
					obj.setState(rowq[z].trim());
				if (z == 7)
					obj.setCountry(rowq[z].trim());
				if (z == 8)
					obj.setZip(rowq[z].trim());
			}
		}
		return obj;
	}

	private String[] selectRowFileAscii(final String row) {
		String[] qzs = new String[9];
		int pos = 0;
		for (int w = 0; w < row.length(); w += 80) {
			qzs[pos] = row.substring(w, w + 80).trim();
			pos++;
		}
		return qzs;
	}

	private DataFilesVO[] orderList(ProcessBean pmbean) {
		DataFilesVO[] lstOrder = null;
		if (pmbean.getLstRows() != null && pmbean.getLstRows().size() > 0) {
			lstOrder = new DataFilesVO[pmbean.getLstRows().size()];
			for (int j = 0; j < pmbean.getLstRows().size(); j++) {
				DataFilesVO l = pmbean.getLstRows().get(j);
				lstOrder[j] = l;
			}
			if (pmbean.getOrderDataFileOutput().equals(PlanetConstants.ORDER_FIRST_NAME))
				Arrays.sort(lstOrder, DataFilesVO.OrderByFirstNameComparator);
			if (pmbean.getOrderDataFileOutput().equals(PlanetConstants.ORDER_LAST_NAME))
				Arrays.sort(lstOrder, DataFilesVO.OrderByLastNameComparator);
			if (pmbean.getOrderDataFileOutput().equals(PlanetConstants.ORDER_START_DATE))
				Arrays.sort(lstOrder, DataFilesVO.OrderByStartDateComparator);
		}
		return lstOrder;
	}

	private void writeToFile(DataFilesVO[] lstOrder) {

		FileWriter fichero = null;
		PrintWriter pw = null;
		Date d = new Date();
		int f = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("(MMMM dd, yyyy)");
		try {
			fichero = new FileWriter(PlanetConstants.ROUTE_FILES 
					+ PlanetConstants.ROUTE_OUTPUTFILE_TXT 
					+ PlanetConstants.NAME_OUTPUTFILE_TXT
					+ d.getTime() + "."
					+ PlanetConstants.EXT_FILES_TXT);
			pw = new PrintWriter(fichero);

			for (DataFilesVO r : lstOrder) {
				pw.println(++f);
				pw.println(r.getFirstName() + " " + r.getLastName() + ", " + sdf.format(r.getDateStartDate()) + ",");
				pw.println(r.getAddressOne() + ", " + r.getAddressTwo() + ",");
				pw.println(r.getCity() + ", " + r.getState() + ",");
				pw.println(r.getCountry() + ", " + r.getZip());
				pw.println("\n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		LOGGER.log(Level.INFO, "Archive output create in ::: " + fichero.toString());
	}
	
	
	private void moveFilesProccesed(ProcessBean pmbean) {
		if(pmbean != null && pmbean.getLstFiles().size() > 0) {
			for(String fi : pmbean.getLstFiles()) {
				File fl = new File(PlanetConstants.ROUTE_FILES + fi);
				if(fl.renameTo(new File(PlanetConstants.ROUTE_FILES + PlanetConstants.ROUTE_ARCHIVE_FILE + fi))) {
					LOGGER.log(Level.INFO, "Archive moved ::: " + fl.toString());
				}
			}
		}
		
	}

}
