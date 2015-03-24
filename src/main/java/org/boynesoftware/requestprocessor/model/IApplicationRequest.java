package org.boynesoftware.requestprocessor.model;

/**
 * Represents a request from an application, these requests can
 * be alerts or requests other requests
 * @author johnwatters
 *
 */
public interface IApplicationRequest extends IRequest {

	/**
	 * The id for the applicationId from where the request has come from
	 * @return
	 */
	public String getApplicationId();
	
	/**
	 * Get the version of the application the request has come from
	 * @return
	 */
	public String getApplicationVersion();
	
	
}
