package actions;

import java.util.List;
import models.SearchFields;
import javax.servlet.ServletContext;
import org.apache.struts2.util.ServletContextAware;
import com.business.DataBeanRemote;
import com.client.EJBClient;
import com.entity.Student;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author Jack Young
 * @date March 08, 2014
 * SWE 645  HW2
 * 
 * Class Purpose:  This is the Driver class for the search functionality in this
 * web application.  
 * 
 */
@SuppressWarnings("rawtypes")
public class SearchDriver extends ActionSupport implements ModelDriven, ServletContextAware {

	private static final long serialVersionUID = 1L;
	private SearchFields searchFields;
	@SuppressWarnings("unused")
	private ServletContext servletContext;
	private List<Student> foundResults;
	
	
	public String search() {
		System.out.println("Search method in Driver was called");
		System.out.println(getSearchFields().toString());
		
		DataBeanRemote bean = EJBClient.doLookup();
		//System.out.println(bean.retrieveAllSurveys());
		
		foundResults = bean.searchByParameters(getSearchFields().getLastname(), getSearchFields().getFirstname(), getSearchFields().getCity(), getSearchFields().getState());
		System.out.println(foundResults);
		if (foundResults.size() == 0) {
			System.out.println("nothing");
			return "nothingFound";
		} else {
			System.out.println("something found");
			return "success";
		}
	}

	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() {
		System.out.println("Driver Execute Method was called");
		return "success";
	}
	
	
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
	

	/**
	 * @return the foundResults
	 */
	public List<Student> getFoundResults() {
		return foundResults;
	}


	/**
	 * @param foundResults the foundResults to set
	 */
	public void setFoundResults(List<Student> foundResults) {
		this.foundResults = foundResults;
	}


	@Override
	public Object getModel() {
		searchFields = new SearchFields();
		return searchFields;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		
	}
}
