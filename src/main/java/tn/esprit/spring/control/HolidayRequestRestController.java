package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.HolidayRequest;
import tn.esprit.spring.services.IHolidayRequestService;

@RestController
public class HolidayRequestRestController {
	@Autowired
	IHolidayRequestService holidayRequestService;

	@GetMapping("/retrieve-all-holidayRequests")
	public Iterable<HolidayRequest> retrieveAllHolidayRequests() {
		Iterable<HolidayRequest> list = holidayRequestService.retrieveAllHolidayRequests();
		return list;
	}

	@GetMapping("/retrieve-holidayRequest/{holidayRequest-id}")
	public HolidayRequest retrieveHolidayRequest(@PathVariable("holidayRequest-id") Long holidayRequestId) {
		return holidayRequestService.retrieveHolidayRequest(holidayRequestId);
	}

	@PostMapping("/add-holidayRequest")
	public HolidayRequest addHolidayRequest(@RequestBody HolidayRequest en) {
		HolidayRequest holidayRequest = holidayRequestService.addHolidayRequest(en);
		return holidayRequest;
	}

	@DeleteMapping("/remove-holidayRequest/{holidayRequest-id}")
	public void removeHolidayRequest(@PathVariable("holidayRequest-id") Long holidayRequestId) {
		holidayRequestService.deleteHolidayRequest(holidayRequestId);
	}

	@PutMapping("/modify-holidayRequest")
	public HolidayRequest updateHolidayRequest(@RequestBody HolidayRequest holidayRequest) {
		return holidayRequestService.updateHolidayRequest(holidayRequest);
	}
}
