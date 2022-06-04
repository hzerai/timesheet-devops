package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Calendar;

@Repository
public interface CalendarRepository extends CrudRepository<Calendar, Long> {

}
