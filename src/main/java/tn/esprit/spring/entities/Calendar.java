package tn.esprit.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Calendar {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long id;

	public String datOfWeek;
	public String month;
	public int year;
	public int hour;
	public int minute;
	public int seconds;
	
	
	public String getDatOfWeek() {
		return datOfWeek;
	}
	public void setDatOfWeek(String datOfWeek) {
		this.datOfWeek = datOfWeek;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	

}
