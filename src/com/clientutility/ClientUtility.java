package com.clientutility;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author Jack Young
 * @date March 07, 2014
 * SWE 645  HW2
 * 
 * This class is a utility class used to read in the jboss
 * ejb client properties
 * 
 */
public class ClientUtility {

	private static Context initialContext;

	private static final String PKG_INTERFACES = "org.jboss.ejb.client.naming";

	public static Context getInitialContext() throws NamingException {
		if (initialContext == null) {
			Properties properties = new Properties();
			properties.put(Context.URL_PKG_PREFIXES, PKG_INTERFACES);

			initialContext = new InitialContext(properties);
		}
		return initialContext;
	}
}