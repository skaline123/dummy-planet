/**
 * 
 */
package mx.com.danito.api.sample.planet.vo;

import java.util.Comparator;
import java.util.Date;

/**
 * @author danito
 *
 */
public class DataFilesVO implements Comparable<DataFilesVO> {

	private String firstName;
	private String lastName; 
	private String startDate;
	private String addressOne;
	private String addressTwo;
	private String city;
	private String state;
	private String country;
	private String zip;
	private Date dateStartDate;
	
	public DataFilesVO(String firstName, String lastName, String startDate, String addressOne, String addressTwo, String city, String state, String country, String zip, Date dateStartDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.startDate = startDate;
		this.addressOne = addressOne;
		this.addressTwo = addressTwo;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
		this.dateStartDate = dateStartDate;
	}
	
	public DataFilesVO() {
	}

	/**
	 * @return the firstName
	 */
	public final String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public final String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the startDate
	 */
	public final String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public final void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the addressOne
	 */
	public final String getAddressOne() {
		return addressOne;
	}
	/**
	 * @param addressOne the addressOne to set
	 */
	public final void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}
	/**
	 * @return the addressTwo
	 */
	public final String getAddressTwo() {
		return addressTwo;
	}
	/**
	 * @param addressTwo the addressTwo to set
	 */
	public final void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}
	/**
	 * @return the city
	 */
	public final String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public final void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public final String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public final void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the country
	 */
	public final String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public final void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the zip
	 */
	public final String getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public final void setZip(String zip) {
		this.zip = zip;
	}
	
	
	public static Comparator<DataFilesVO> OrderByFirstNameComparator = new Comparator<DataFilesVO>() {
		
		public int compare(DataFilesVO od1, DataFilesVO od2) {
			String d1 = od1.getFirstName().toUpperCase();
			String d2 = od2.getFirstName().toUpperCase();
			return d1.compareTo(d2);
		}
	};
	

	public static Comparator<DataFilesVO> OrderByLastNameComparator = new Comparator<DataFilesVO>() {
		
		public int compare(DataFilesVO od1, DataFilesVO od2) {
			String d1 = od1.getLastName().toUpperCase();
			String d2 = od2.getLastName().toUpperCase();
			return d1.compareTo(d2);
		}
	};
	

	public static Comparator<DataFilesVO> OrderByStartDateComparator = new Comparator<DataFilesVO>() {
		
		public int compare(DataFilesVO od1, DataFilesVO od2) {
			String d1 = od1.getStartDate().toUpperCase();
			String d2 = od2.getStartDate().toUpperCase();
			return d1.compareTo(d2);
		}
	};	



	@Override
	public int compareTo(DataFilesVO o) {
		return 0;
	}

	/**
	 * @return the dateStartDate
	 */
	public final Date getDateStartDate() {
		return dateStartDate;
	}

	/**
	 * @param dateStartDate the dateStartDate to set
	 */
	public final void setDateStartDate(Date dateStartDate) {
		this.dateStartDate = dateStartDate;
	}}
