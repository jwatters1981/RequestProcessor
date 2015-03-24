package org.boynesoftware.requestprocessor.service;

import org.boynesoftware.requestprocessor.model.NotificationMessage;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

@Service
public class QueueMessageNotificationService implements IMessageNotificationService {

	private RabbitMessagingTemplate rabbitMessagingTemplate;
	private MessageConverter messageConverter;
	public void processNotification(NotificationMessage request) {
		rabbitMessagingTemplate.convertAndSend(request);
	}
}
