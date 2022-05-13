package tn.esprit.spring.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.HolidayRequest;

@Repository
public interface HolidayRequestRepository extends CrudRepository<HolidayRequest, Long> {

	Optional<HolidayRequest> findById(Long id);

	Collection<HolidayRequest> findByEmployeeId(Long employeeId);

}
