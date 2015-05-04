package com.client;


import javax.naming.Context;
import javax.naming.NamingException;
import com.business.DataBeanRemote;
//import com.businesslogic.DataBean;
import com.clientutility.ClientUtility;

/**
 * @author Jack Young
 * @date February 07, 2014
 * SWE 645  HW1
 * 
 * Class Purpose:  This is the ejb client which is used to establish a connection
 * between the web application and the ejb.  
 * 
 */
public class EJBClient {


	public static DataBeanRemote doLookup() {
		Context context = null;
		DataBeanRemote bean = null;
		try {
			// 1. Obtaining Context
			context = ClientUtility.getInitialContext();
			// 2. Generate JNDI Lookup name
			//String lookupName = getLookupName();
			// 3. Lookup and cast
			//bean = (DataBeanRemote) context.lookup("ejb:/jyoung17_session_hw2//DataBean!com.business.DataBeanRemote");
			bean = (DataBeanRemote) context.lookup("ejb:jyoung17_swe645_hw2/jyoung17_session_hw2/DataBean!com.business.DataBeanRemote");
																			 //"/jyoung17_swe645_hw2/jyoung17_session_hw2/DataBean!com.business.DataBeanRemote"
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return bean;
	}

}
