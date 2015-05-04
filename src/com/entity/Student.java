package com.entity;
import java.io.Serializable;
import java.util.Arrays;

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

public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String streetAddress;
	private String city;
	private String state;
	private String zip;
	private String telephoneNumber;
	private String email;
	private String dataOfSurvey;
	private String[] likedAboutCampus;
	private String originOfInterest;
	private String likelyhoodOfRecommendation;
	private String raffle;
	private String comments;
	
	
	/**
	 * No arg Constructor
	 */
	public Student() {
		this.firstName = "";
		this.lastName = "";
		this.streetAddress = "";
		this.city = "";
		this.state = "";
		this.zip = "";
		this.telephoneNumber = "";
		this.email = "";
		this.dataOfSurvey = "";
//		this.likedAboutCampus = "";
		this.originOfInterest = "";
		this.likelyhoodOfRecommendation = "";
		this.raffle = "";
		this.comments = "";
	}
	
	
	/**
	 * Arg Constructor
	 * 
	 * @param firstName
	 * @param lastName
	 * @param streetAddress
	 * @param city
	 * @param state
	 * @param zip
	 * @param telephoneNumber
	 * @param email
	 * @param dataOfSurvey
	 * @param likedAboutCampus
	 * @param originOfInterest
	 * @param likelyhoodOfRecommendation
	 * @param raffle
	 * @param comments
	 */
	public Student(String firstName, String lastName, String streetAddress,
			String city, String state, String zip, String telephoneNumber,
			String email, String dataOfSurvey, String[] likedAboutCampus,
			String originOfInterest, String likelyhoodOfRecommendation,
			String raffle, String comments) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.telephoneNumber = telephoneNumber;
		this.email = email;
		this.dataOfSurvey = dataOfSurvey;
		this.likedAboutCampus = likedAboutCampus;
		this.originOfInterest = originOfInterest;
		this.likelyhoodOfRecommendation = likelyhoodOfRecommendation;
		this.raffle = raffle;
		this.comments = comments;
	}
	
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the streetAddress
	 */
	public String getStreetAddress() {
		return streetAddress;
	}
	/**
	 * @param streetAddress the streetAddress to set
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
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
	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	/**
	 * @return the telephoneNumber
	 */
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	/**
	 * @param telephoneNumber the telephoneNumber to set
	 */
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the dataOfSurvey
	 */
	public String getDataOfSurvey() {
		return dataOfSurvey;
	}
	/**
	 * @param dataOfSurvey the dataOfSurvey to set
	 */
	public void setDataOfSurvey(String dataOfSurvey) {
		this.dataOfSurvey = dataOfSurvey;
	}
	/**
	 * @return the likedAboutCampus
	 */
	public String[] getLikedAboutCampus() {
		return likedAboutCampus;
	}
	/**
	 * @param likedAboutCampus the likedAboutCampus to set
	 */
	public void setLikedAboutCampus(String[] likedAboutCampus) {
		this.likedAboutCampus = likedAboutCampus;
	}
	/**
	 * @return the originOfInterest
	 */
	public String getOriginOfInterest() {
		return originOfInterest;
	}
	/**
	 * @param originOfInterest the originOfInterest to set
	 */
	public void setOriginOfInterest(String originOfInterest) {
		this.originOfInterest = originOfInterest;
	}
	/**
	 * @return the likelyhoodOfRecommendation
	 */
	public String getLikelyhoodOfRecommendation() {
		return likelyhoodOfRecommendation;
	}
	/**
	 * @param likelyhoodOfRecommendation the likelyhoodOfRecommendation to set
	 */
	public void setLikelyhoodOfRecommendation(String likelyhoodOfRecommendation) {
		this.likelyhoodOfRecommendation = likelyhoodOfRecommendation;
	}
	/**
	 * @return the raffle
	 */
	public String getRaffle() {
		return raffle;
	}
	/**
	 * @param raffle the raffle to set
	 */
	public void setRaffle(String raffle) {
		this.raffle = raffle;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}


	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName
				+ ", streetAddress=" + streetAddress + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", telephoneNumber="
				+ telephoneNumber + ", email=" + email + ", dataOfSurvey="
				+ dataOfSurvey + ", likedAboutCampus="
				+ Arrays.toString(likedAboutCampus) + ", originOfInterest="
				+ originOfInterest + ", likelyhoodOfRecommendation="
				+ likelyhoodOfRecommendation + ", raffle=" + raffle
				+ ", comments=" + comments + "]";
	}


	/**
	 * This method is used to produced a string representation
	 * of the student object, in a specialized storage format
	 * manner.  This string is then returned to the calling
	 * method. 
	 * 
	 * @return String
	 */
	public String textFileStorageFormat() {
		String s =  "{" + firstName + "}{" + lastName
				+ "}{" + streetAddress + "}{" + city
				+ "}{" + state + "}{" + zip + "}{"
				+ telephoneNumber + "}{" + email + "}{"
				+ dataOfSurvey + "}{";
			for (int i = 0; i < likedAboutCampus.length; i++) {
				s += likedAboutCampus[i] + ",";
			}
		
			s += "}{" + originOfInterest
				+ "}{" + likelyhoodOfRecommendation
				+ "}{" + raffle + "}{" + comments + "}";
		
		return s;
	}
	
	public String queryInsertFormat() {
		String s = " VALUES (";
		s += "seq_swe.nextval,";
		s += "'" + firstName + "',";
		s += "'" + lastName + "',";
		s += "'" + streetAddress + "',";
		s += "'" + city + "',";
		s += "'" + state + "',";
		s += "'" + zip + "',";
		s += "'" + telephoneNumber + "',";
		s += "'" + email + "',";
		s += "'" + dataOfSurvey + "',";
		String r = "";
		for (int i = 0; i < likedAboutCampus.length; i++) {
			r += likedAboutCampus[i] + ",";
		}
		s += "'" + r + "',";
		s += "'" + originOfInterest + "',";
		s += "'" + likelyhoodOfRecommendation + "',";
		s += "'" + raffle + "',";
		s += "'" + comments + "'";
		s += ")";
		return s;
	}
	
}
