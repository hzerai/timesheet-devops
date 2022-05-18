package tn.esprit.spring.services;

import java.time.LocalDate;
import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.HolidayRequest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HolidayRequestServiceTest {

	@Autowired
	private IHolidayRequestService holidayRequestService;

	@Test
	@Order(1)
	public void testAddHolidayRequest() {
		HolidayRequest hr = new HolidayRequest();
		hr.setEmployeeId(1L);
		hr.setFromDate(LocalDate.parse("2007-12-03"));
		hr.setToDate(LocalDate.parse("2022-12-08"));
		hr = holidayRequestService.addHolidayRequest(hr);
		Assertions.assertEquals(1L, hr.getId());
		HolidayRequest hr2 = new HolidayRequest();
		hr2.setEmployeeId(2L);
		hr2.setFromDate(LocalDate.parse("2007-12-05"));
		hr2.setToDate(LocalDate.parse("2022-12-06"));
		holidayRequestService.addHolidayRequest(hr2);
		Assertions.assertEquals(2L, hr2.getId());
	}

	@Test
	@Order(2)
	public void testRetrieveAllHolidayRequests() {
		Collection<HolidayRequest> hrs = (Collection<HolidayRequest>) holidayRequestService
				.retrieveAllHolidayRequests();
		Assertions.assertEquals(2, hrs.size());

	}

	@Test
	@Order(3)
	public void testRetrieveHolidayRequest() {
		HolidayRequest hr = holidayRequestService.retrieveHolidayRequest(1L);
		Assertions.assertEquals(1L, hr.getId());
	}

	@Test
	@Order(4)
	public void testUpdateHolidayRequest() {
		HolidayRequest hr = holidayRequestService.retrieveHolidayRequest(1L);
		hr.setToDate(LocalDate.parse("2022-12-10"));
		holidayRequestService.updateHolidayRequest(hr);
		hr = holidayRequestService.retrieveHolidayRequest(1L);
		Assertions.assertEquals(LocalDate.parse("2022-12-10"), hr.getToDate());
	}

	@Test
	@Order(5)
	public void testRetrieveEmployeeHolidayRequests() {
		Collection<HolidayRequest> hrs = (Collection<HolidayRequest>) holidayRequestService.retrieveEmployeeHolidayRequests(1L);
		Assertions.assertEquals(1, hrs.size());
		Assertions.assertEquals(1L, hrs.iterator().next().getEmployeeId());
	}

	@Test
	@Order(6)
	public void testDeleteHolidayRequest() {
		holidayRequestService.deleteHolidayRequest(1L);
		Assertions.assertNull(holidayRequestService.retrieveHolidayRequest(1L));
	}
}
