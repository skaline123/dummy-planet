/**
 * 
 */
package mx.com.danito.api.sample.planet.bean;

import java.io.Serializable;
import java.util.List;

import mx.com.danito.api.sample.planet.util.EnumMenuPlanet;
import mx.com.danito.api.sample.planet.vo.DataFilesVO;

/**
 * @author danito
 *
 */
public class ProcessBean implements Serializable {

	private static final long serialVersionUID = 1;

	private String[] args;
	private boolean validator;
	private EnumMenuPlanet menu;
	private List<String> lstFiles;
	
	private String orderDataFileOutput;
	private List<DataFilesVO> lstRows;
	
	
	
	/**
	 * @return the args
	 */
	public final String[] getArgs() {
		return args;
	}
	/**
	 * @param args the args to set
	 */
	public final void setArgs(String[] args) {
		this.args = args;
	}
	/**
	 * @return the validator
	 */
	public final boolean isValidator() {
		return validator;
	}
	/**
	 * @param validator the validator to set
	 */
	public final void setValidator(boolean validator) {
		this.validator = validator;
	}
	/**
	 * @return the menu
	 */
	public final EnumMenuPlanet getMenu() {
		return menu;
	}
	/**
	 * @param menu the menu to set
	 */
	public final void setMenu(EnumMenuPlanet menu) {
		this.menu = menu;
	}
	/**
	 * @return the lstFiles
	 */
	public final List<String> getLstFiles() {
		return lstFiles;
	}
	/**
	 * @param lstFiles the lstFiles to set
	 */
	public final void setLstFiles(List<String> lstFiles) {
		this.lstFiles = lstFiles;
	}
	/**
	 * @return the orderDataFileOutput
	 */
	public final String getOrderDataFileOutput() {
		return orderDataFileOutput;
	}
	/**
	 * @param orderDataFileOutput the orderDataFileOutput to set
	 */
	public final void setOrderDataFileOutput(String orderDataFileOutput) {
		this.orderDataFileOutput = orderDataFileOutput;
	}
	/**
	 * @return the lstRows
	 */
	public final List<DataFilesVO> getLstRows() {
		return lstRows;
	}
	/**
	 * @param lstRows the lstRows to set
	 */
	public final void setLstRows(List<DataFilesVO> lstRows) {
		this.lstRows = lstRows;
	}
	
	

}
