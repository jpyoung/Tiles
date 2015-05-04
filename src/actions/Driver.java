package actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;

import businessLogic.StudentService;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;

import models.SearchFields;
import com.entity.Student;
import models.WinningResult;

import com.business.DataBeanRemote;
import com.client.EJBClient;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author Jack Young
 * @date February 07, 2014
 * SWE 645  HW1
 * 
 * Class Purpose:  The Driver class is the model driven action class.  
 * It is the controller for this web application.  It contains the appropriate 
 * references to the model objects (Student & WinningResult).  Furthermore, 
 * this action class provides multiple methods to support different actions 
 * from the users.  This action class has also overridden the validate method 
 * for the field specific error checking.  In conjunction with the standard validate 
 * method, this class also provides a number of specific input error checking 
 * methods (i.e. for formatting and etc). 
 * 
 */

@SuppressWarnings("rawtypes")
public class Driver extends ActionSupport implements ModelDriven, ServletContextAware {

	//default serial id added to get rid of the warning message
	private static final long serialVersionUID = 1L;

	private Student student;
	private ServletContext servletContext;
	private List<Student> allTakenSurveys;
	private WinningResult winningResult;
	
	
	private SearchFields searchFields;
	
	
	
	/**
	 * @return the searchFields
	 */
	public SearchFields getSearchFields() {
		return searchFields;
	}


	/**
	 * @param searchFields the searchFields to set
	 */
	public void setSearchFields(SearchFields searchFields) {
		this.searchFields = searchFields;
	}


	public String search() {
		System.out.println("Search method in Driver was called");
		System.out.println(searchFields);
		return "success";
	}
	
	
	public String home() {
		System.out.println("Home page view");
		return "home";
	}
	
	
	/**
	 * This method is called when the user submits the survey form.
	 * Depending on the input raffle numbers, it will redirect them to
	 * a another jsp page.  If their average is greater than 90, then they 
	 * will go to the WinnerAcknowledgement.jsp page, else they will go
	 * to the SimpleAcknowledgement.jsp page. 
	 * 
	 * @return string message
	 */
	public String submit() {
		System.out.println(student);
		
		StudentService.FILENAME = servletContext.getRealPath("submitted_surveys.txt");
		
		System.out.println("The path shall be:  " + servletContext.getRealPath("submitted_surveys.txt"));
		
		//Writing the students information to the text file.
		StudentService.writeOut(student);
		
		//inserting the student into the Database.
		DataBeanRemote bean = EJBClient.doLookup();
		bean.insertStudentSurveyRecord(student);
		
		
		setWinningResult(StudentService.calculate(student.getRaffle()));
				
		servletContext.setAttribute("compMean", getWinningResult().getMean());
		servletContext.setAttribute("compStdv", getWinningResult().getStdv());
		
		if (getWinningResult().getMean() > 90) {
			return "winner";
		}
		return "success";
	}



	/**
	 * This method is called when the user clicks the view
	 * list surveys on the home page.  This will redirect the user
	 * to the ListSurvey.jsp page.  
	 * 
	 * @return success message
	 */
	public String gotoListView() {
		System.out.println("goToListView method was called");
		
		//Manually setting the servletContext to avoid NPE
		setServletContext(ServletActionContext.getServletContext());
		StudentService.FILENAME = servletContext.getRealPath("submitted_surveys.txt");
		if (servletContext == null) {
			System.out.println("The servlet Context has been found to be null");
		} 
		
		DataBeanRemote bean = EJBClient.doLookup();
		
//		if (bean.ableToConnect()) {
//			System.out.println("EJB was able to connect to the database.");
//			System.out.println(bean.retrieveAllSurveys());
//		} else {
//			System.out.println("Error: the EJB was not able to connect to the database");
//		}

		//retrieving all the records from the database via the EJB
		allTakenSurveys = bean.retrieveAllSurveys();
		
		return "success";
	}
	
	
	/**
	 * This method is called when the user clicks the button
	 * on the home page, this will bring the user to the 
	 * survey.jsp page.  There the user will be able to fillout
	 * the survey form. 
	 * 
	 * @return success message
	 */
	public String gotoSurveyView() {
		System.out.println("gotoSurveyView method was called");
		return "success";
	}
	
	
	public String gotoSearchRecordsView() {
		System.out.println("gotoSearchRecordsView method was called");
		return "success";
	}
	
	
	/**
	 * This method is called when the user clicks the cancel
	 * button in the survey form on the survey.jsp page. By
	 * pressing the cancel button, the user is redirected back
	 * to the home page.
	 * 
	 * @return  success message
	 */
	public String cancelSurvey() {
		System.out.println("cancelSurvey method was called, user will be return to the Homepage");
		return "success";
	}
	
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() {
		System.out.println("Driver Execute Method was called");
		return "success";
	}
	
/*************************************************************************************/
/************************   Getter/Setter Methods       ********************************/
/*************************************************************************************/	
	
	/**
	 * @return the winningResult
	 */
	public WinningResult getWinningResult() {
		return winningResult;
	}

	/**
	 * @param winningResult the winningResult to set
	 */
	public void setWinningResult(WinningResult winningResult) {
		this.winningResult = winningResult;
	}

	/**
	 * @return the allSurveys
	 */
	public List<Student> getAllTakenSurveys() {
		return allTakenSurveys;
	}

	/**
	 * @param allSurveys the allSurveys to set
	 */
	public void setAllTakenSurveys(List<Student> allSurveys) {
		this.allTakenSurveys = allSurveys;
	}
	
	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public Object getModel() {
		student = new Student();
		return student;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		
	}
	
/*************************************************************************************/
/************************   Validation Methods       ***********************************/
/*************************************************************************************/
	
	public void validate() {
		
		String e = " cannot be blank."; 
		if(StringUtils.isEmpty(student.getOriginOfInterest()) ) {
			addFieldError("originOfInterest", "originOfInterest must have a selected a radio option");
		}
		
		if (student.getLikedAboutCampus().length < 1) {
			addFieldError("likedAboutCampus", "likedAboutCampus must have a selected check box.");
		}
		
		
		System.out.println("Validate Method was called");
		if (StringUtils.isEmpty(student.getFirstName())) {
			addFieldError("firstName", "First name" + e);
		}
		
		if (StringUtils.isEmpty(student.getStreetAddress())) {
			String it = "streetAddress";
			addFieldError(it, it + e);
		} 
		
		if (StringUtils.isEmpty(student.getCity())) {
			String it = "city";
			addFieldError(it, it + e);
		} 
		
		if (StringUtils.isEmpty(student.getState())) {
			String it = "state";
			addFieldError(it, it + e);
		} 
		
		if (StringUtils.isEmpty(student.getZip())) {
			String it = "zip";
			addFieldError(it, it + e);
		} else if(!validateZipCode(student.getZip())) {
			addFieldError("zip", "Zip does not appear to be in the correct format. (i.e. xxxxx)");
		}
		
		if (StringUtils.isEmpty(student.getTelephoneNumber())) {
			String it = "telephoneNumber";
			addFieldError(it, it + e);
		} else if (!validatePhoneNumber(student.getTelephoneNumber())) {
			addFieldError("telephoneNumber", "Telephone number does not appear to be in the correct format. (i.e. xxx-xxx-xxxx)");
		}
		
		if (StringUtils.isEmpty(student.getEmail())) {
			String it = "email";
			addFieldError(it, it + e);
		}  else if (!emailValidate(student.getEmail())) {
			addFieldError("email", "Email does not appear to be in a correct email format.");
		}
		
		if (StringUtils.isEmpty(student.getDataOfSurvey())) {
			String it = "dataOfSurvey";
			addFieldError(it, it + e);
		} else if (!validateSurveyDate(student.getDataOfSurvey())) {
			addFieldError("dataOfSurvey", "DataOfSurvey format should be mm-dd-yyyy");
		}
		
		
		if (StringUtils.isEmpty(student.getRaffle())) {
			addFieldError("raffle", "Raffle cannot be empty");
		} else if (!validateRaffleInput(student.getRaffle())) {
			addFieldError("raffle", "Raffle does not be the requirements.");
		}
		
	}
	
	
	/**
	 * This method is used to validate the enter survey
	 * date.
	 * 
	 * @param survey date
	 * @return boolean
	 */
	public static boolean validateSurveyDate(String n) {
		// EFFECTS: if n is null return false, if the survey date
		// 			   is not in this format mm-dd-yyyy return 
		//				   false, else return true.
		
		if (n == null) {
			return false;
		}
		Pattern pattern = Pattern.compile("\\d{2}-\\d{2}-\\d{4}");
		Matcher matcher = pattern.matcher(n);

		if (matcher.matches()) {
			return true;
		}
		return false;
	}
	
	/**
	 * This method is used to validate the entered zip code
	 * 
	 * @param zip code
	 * @return boolean
	 */
	public static boolean validateZipCode(String n) {
		// EFFECTS: if n is null return false, if the zip is not
		//				   in this format xxxxx return false, else
		//				   return true.
		
		if (n == null) {
			return false;
		}
		Pattern pattern = Pattern.compile("\\d{5}");
		Matcher matcher = pattern.matcher(n);

		if (matcher.matches()) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * This method is used to validate the entered phone number
	 * 
	 * @param phone number
	 * @return boolean
	 */
	public static boolean validatePhoneNumber(String n) {
		// EFFECTS: if n is null return false, if the number is
		//				   not in this format xxx-xxx-xxx return 
		//				   false, else return true.
		
		if (n == null) {
			return false;
		}
		Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
		Matcher matcher = pattern.matcher(n);

		if (matcher.matches()) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * This method validates the passed in email address.
	 * It returns false if, email is: null, less than three characters
	 * long, missing @ symbol, and if its missing a period.  Else
	 * this method returns true.  
	 * 
	 * @param email
	 * @return boolean
	 */
	public static boolean emailValidate(String email) {
		if (email == null) {
			return false;
		}
		if ((email.trim().length() < 3) || (email.indexOf("@") == -1)) {
			return false;
		}
		if (email.indexOf(".") == -1){
			return false;
		}
		return true;
	}
	
	
	/**
	 * This method is used to validate the Raffle Input.
	 * The input must be 10 numbers seperated by a comma.
	 * The numbers need to be in an Inclusive range of 1 to 100.
	 * If its not in that range, or not numbers, or don't have 10 numbers
	 * , or if its null: this method will return false.  Else it must be a valid
	 * raffle selection, and true is returned.  
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean validateRaffleInput(String str) {

		if (str == null || str.length() <= 0) {
			System.out.println("Error. Either null or its a empty string");
			return false;
		}
		if (str.indexOf(',') == -1) {
			System.out.println("Error. This string has no commas at all");
			return false;
		}
		List<String> e = Arrays.asList(str.trim().split("\\s*,\\s*"));

		if (e.size() != 10) {
			System.out.println("Error. There are not 10 items seperated by 9 commas");
			return false;
		}
		List<Double> d = new ArrayList<Double>();
		for (int i = 0; i < e.size(); i++) {
			String temp = e.get(i);
			if (!isNumeric(temp)) {
				System.out.println("Error, a letter was found in your raffle input. They need to be numbers");
				return false;
			} else {
				double tp = Double.parseDouble(temp);
				if (tp >= 1 && tp <= 100) {
					d.add(tp);
				} else {
					System.out.println("Error, the raffle numbers need to be in the range of 1 to 100 (Inclusive)");
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * This method is used to check whether or not the 
	 * passed in string is in fact a number. If it is, then return 
	 * true, else return false. 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		try {
			@SuppressWarnings("unused")
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}


}

	

