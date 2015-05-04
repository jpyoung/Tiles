package com.business;

import javax.ejb.Remote;
import com.entity.Student;
import java.util.List;

/**
 * @author Jack Young
 * @date March 07, 2014
 * SWE 645  HW2
 * 
 * Class Purpose:  This is the Interface for the DataBean.  
 * 
 */

@Remote
public interface DataBeanRemote {
	
	public boolean insertStudentSurveyRecord(Student newStudent);

	public List<Student> searchByParameters(String last, String first, String cityy, String statee);
	
	public List<Student> retrieveAllSurveys();
	
	
}
