package tn.esprit.spring.services;

import java.util.Collection;

import tn.esprit.spring.entities.Calendar;

public interface ICalendarService {
	
	public Collection<Calendar> findAll();
	
	public Calendar save(Calendar calendar);

}
