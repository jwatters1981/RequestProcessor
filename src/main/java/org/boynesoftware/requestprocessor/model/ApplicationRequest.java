package org.boynesoftware.requestprocessor.model;

public class ApplicationRequest implements IApplicationRequest {

	private String source;
	private String applicationId;
	private String applicationVersion;

	public String getSource() {
		return source;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public String getApplicationVersion() {
		return applicationVersion;
	}

}
