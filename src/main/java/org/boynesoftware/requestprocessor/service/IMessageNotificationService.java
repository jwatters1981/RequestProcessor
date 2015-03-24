package org.boynesoftware.requestprocessor.service;

import org.boynesoftware.requestprocessor.model.NotificationMessage;

/**
 * Responsible for processing notification or sending messages to
 * required notification integration points like queues, restful services etc
 * @author johnwatters
 *
 */
public interface IMessageNotificationService {

	public void processNotification(NotificationMessage message);
}
