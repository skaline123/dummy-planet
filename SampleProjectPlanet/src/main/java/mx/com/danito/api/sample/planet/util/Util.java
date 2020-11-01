/**
 * 
 */
package mx.com.danito.api.sample.planet.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mx.com.danito.api.sample.planet.bean.ProcessBean;

/**
 * @author danito
 *
 */
public class Util {

	private final static Logger LOGGER = LogManager.getLogger(Util.class);

	public static ProcessBean validValuesEntry(String[] args, ProcessBean pmbean) {

		try {
			if (args != null && args.length > 0) {
				LOGGER.log(Level.INFO, "Valid if exist de parameter ... ");
				pmbean = validMenuExist(args, pmbean);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pmbean;
	}

	public static ProcessBean validMenuExist(String[] args, ProcessBean pmbean) {

		if (args.length > 0) {
			for (EnumMenuPlanet a : EnumMenuPlanet.values()) {
				if (args[0].equals(a.getId())) {
					pmbean.setMenu(a);
					pmbean.setValidator(true);
					break;
				}
			}
			if (args.length > 1) {
				for (EnumOrderDataPlanet a : EnumOrderDataPlanet.values()) {
					if (args[1].equals(a.getId())) {
						pmbean.setOrderDataFileOutput(a.getId());
						pmbean.setValidator(true);
						break;
					} else
						pmbean.setValidator(false);
				}
			}
		}
		return pmbean;
	}

	public static void detectFiles(ProcessBean pmbean, String route, String extention) {
		final File folder = new File(route);
		List<String> lstFile = new ArrayList<String>();
		for (final File ficheroEntrada : folder.listFiles()) {
			if (!ficheroEntrada.isDirectory()) {
				if (checkExtention(ficheroEntrada, extention)) {
					System.out.println(ficheroEntrada.getName());
					lstFile.add(ficheroEntrada.getName());
				}
			}
		}
		pmbean.setLstFiles(lstFile);
	}

	private static boolean checkExtention(File dir, String extention) {
		return dir.getName().endsWith(extention);
	}

	
	
	public static List<String> readFileInList(String fileName) {

		List<String> lines = Collections.emptyList();
		try {
			lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
		}

		catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

}
