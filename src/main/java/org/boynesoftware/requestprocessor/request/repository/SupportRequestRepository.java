package org.boynesoftware.requestprocessor.request.repository;

import java.util.List;

import org.boynesoftware.requestprocessor.model.SupportRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportRequestRepository extends CrudRepository<SupportRequest, Long> {

	List<SupportRequest> findByType(String type);
}
