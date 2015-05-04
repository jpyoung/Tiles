package models;

/**
 * @author Jack Young
 * @date February 07, 2014
 * SWE 645
 * 
 * Class Purpose: This class contains the fields/attributes that were
 * specified in the instructions.  These attributes match the fields on
 * the student survey form.  
 * 
 */

public class SearchFields {
	
	private String lastname;
	private String firstname;
	private String city;
	private String state;
	
	public SearchFields() {
		this.lastname = "";
		this.firstname = "";
		this.city = "";
		this.state = "";
	}

	/**
	 * @param lastname
	 * @param firstname
	 * @param city
	 * @param state
	 */
	public SearchFields(String lastname, String firstname, String city, String state) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.city = city;
		this.state = state;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SearchFields [lastname=" + lastname + ", firstname="
				+ firstname + ", city=" + city + ", state=" + state + "]";
	}
	
	

}
