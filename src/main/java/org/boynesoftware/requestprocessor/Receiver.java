package org.boynesoftware.requestprocessor;

import java.util.concurrent.CountDownLatch;

import org.boynesoftware.configuration.application.service.IApplicationService;
import org.boynesoftware.requestprocessor.model.SupportRequest;
import org.boynesoftware.requestprocessor.request.repository.SupportRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Receiver {

	private CountDownLatch latch = new CountDownLatch(1);

	@Autowired
	private SupportRequestRepository supportRequestRepository;
	
	@Autowired
	private IApplicationService applicationService;
	
	public void handleMessage(SupportRequest s)
	{
	
	
		supportRequestRepository.save(s);
		Iterable<SupportRequest> list = supportRequestRepository.findAll();
		for (SupportRequest supportRequest : list) {
			System.out.println(supportRequest.getFrom());
		}
		
	}

	public CountDownLatch getLatch() {
		return latch;
	}

}
