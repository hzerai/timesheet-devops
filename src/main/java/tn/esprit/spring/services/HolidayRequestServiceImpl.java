package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.HolidayRequest;
import tn.esprit.spring.repository.HolidayRequestRepository;

@Service
public class HolidayRequestServiceImpl implements IHolidayRequestService {

	@Autowired
	HolidayRequestRepository hRepository;

	private static final Logger l = LogManager.getLogger(HolidayRequestServiceImpl.class);

	@Override
	public Iterable<HolidayRequest> retrieveAllHolidayRequests() {
		List<HolidayRequest> hrs = null;
		try {

			l.info("In Method retrieveAllHolidayRequests :");
			hrs = (List<HolidayRequest>) hRepository.findAll();
			l.debug("connexion à la DB Ok :");
			hrs.forEach(hr -> l.debug("Holiday request id :" + hr.getId()));
			l.info("Out of Method retrieveAllHolidayRequests with Success" + hrs.size());
		} catch (Exception e) {
			l.error("Out of Method retrieveAllHolidayRequests with Errors : ", e);
			throw e;
		}

		return hrs;
	}

	@Override
	public HolidayRequest addHolidayRequest(HolidayRequest hr) {
		try {
			l.info("begin saveHolidayRequest");
			hr = hRepository.save(hr);
			l.info("end saveHolidayRequest, id = " + hr.getId());
		} catch (Exception e) {
			l.error("Error saving holiday request : ", e);
			throw e;
		}

		return hr;
	}

	@Override
	public HolidayRequest updateHolidayRequest(HolidayRequest hr) {
		try {
			l.info("begin updateHolidayRequest");
			hr = hRepository.save(hr);
			l.info("end updateHolidayRequest, id = " + hr.getId());
		} catch (Exception e) {
			l.error("Error updating holiday request : ", e);
			throw e;
		}
		return hr;
	}

	@Override
	public void deleteHolidayRequest(Long id) {
		try {
			l.info("begin deleteHolidayRequest");
			hRepository.deleteById(id);
			l.info("end deleteHolidayRequest, id = " + id);
		} catch (Exception e) {
			l.error("Error deleting holiday request : ", e);
			throw e;
		}

	}

	@Override
	public HolidayRequest retrieveHolidayRequest(Long id) {
		try {
			l.info("begin retrieveHolidayRequest");
			Optional<HolidayRequest> opt_hr = hRepository.findById(id);
			if (opt_hr.isPresent()) {
				HolidayRequest hr = opt_hr.get();
				l.info("found HolidayRequest :" + hr.toString());
				return hr;
			} else {
				l.info("HolidayRequest with id " + id + " not found!");
				return null;
			}
		} catch (Exception e) {
			l.error("Error finding holiday request", e);
			throw e;
		}
	}

	@Override
	public Iterable<HolidayRequest> retrieveEmployeeHolidayRequests(Long id) {
		Iterable<HolidayRequest> result;
		try {
			l.info("begin retrieveEmployeeHolidayRequests");
			result = hRepository.findByEmployeeId(id);
			l.info("end retrieveEmployeeHolidayRequests");
		} catch (Exception e) {
			l.error("Error finding holiday requests of user", e);
			throw e;
		}
		return result;
	}

}
