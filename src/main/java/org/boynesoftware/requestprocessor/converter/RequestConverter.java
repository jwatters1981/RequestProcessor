package org.boynesoftware.requestprocessor.converter;

import org.boynesoftware.requestprocessor.model.ApplicationRequest;
import org.boynesoftware.requestprocessor.model.SupportRequest;


/**
 * Used to process R
 * @author johnwatters
 *
 */
public class RequestConverter {
	public void processRequest(ApplicationRequest request)
	{
		request.getApplicationId();
		System.err.println("Processing request");
	}
	
	public void processRequest(SupportRequest request)
	{
	}	
}
