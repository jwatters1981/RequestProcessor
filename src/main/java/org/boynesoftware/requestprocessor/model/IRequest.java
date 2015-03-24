package org.boynesoftware.requestprocessor.model;

public interface IRequest {

	/**
	 * Returns a String id of the source of the request.  The source
	 * can be a system or person
	 * @return
	 */
	public String getSource();
}
