package tn.esprit.spring.services;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Calendar;
import tn.esprit.spring.repository.CalendarRepository;

@Service
public class CalendarServiceImpl implements ICalendarService{
	
	@Autowired
	CalendarRepository calendarRepository;
	
	private static final Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);

	@Override
	public Collection<Calendar> findAll() {
		logger.info("In Method find All Calendars :");
		return (Collection<Calendar>) calendarRepository.findAll();
	}

	@Override
	public Calendar save(Calendar calendar) {
		logger.info("saving the calendar");
		return calendarRepository.save(calendar);
	}
	

}
