package tn.esprit.spring.services;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Calendar;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class CalendarServiceTest {

	@Autowired
	private ICalendarService calendarService;

	@Test
	@Order(1)
	public void testFindAll() {
		List<Calendar> listCalendars = calendarService.findAll().stream().collect(Collectors.toList());
		Assertions.assertEquals(0, listCalendars.size());
	}

	@Test
	@Order(2)
	public void save() {
		Calendar calendarToSave = new Calendar();
		calendarToSave.setDatOfWeek("Monday");
		Calendar savedCalendar = calendarService.save(calendarToSave);
		Assertions.assertEquals("Monday", savedCalendar.getDatOfWeek());
	}

}
