package org.boynesoftware.requestprocessor.service;

/**
 * Gets the wait time for a message to be processed.
 * This can be used in order to ensure other similar messages 
 * are included in any processing
 * @author johnwatters
 *
 */
public interface IMessageWaitService {

	/**
	 * Returns the wait time for the give message type.
	 * If no wait time is specified zero will be returned.
	 * @param messageType - Cannot be null, IllegalArgumentException will be thrown
	 * @return the given wait time in milliseconds or 0 if none
	 */
	public long getWaitTimeForMessage(String messageType);
}
