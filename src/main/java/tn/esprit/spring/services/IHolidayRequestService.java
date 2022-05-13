package tn.esprit.spring.services;

import tn.esprit.spring.entities.HolidayRequest;

public interface IHolidayRequestService { 
	 
	Iterable<HolidayRequest> retrieveAllHolidayRequests(); 
	HolidayRequest addHolidayRequest(HolidayRequest hr);
	void deleteHolidayRequest(Long id);
	HolidayRequest updateHolidayRequest(HolidayRequest hr);
	HolidayRequest retrieveHolidayRequest(Long id);
	Iterable<HolidayRequest> retrieveEmployeeHolidayRequests(Long id);

} 
 