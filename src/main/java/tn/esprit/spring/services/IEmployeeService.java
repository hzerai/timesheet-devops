package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Employe;

public interface IEmployeeService {
	
	List<Employe> retrieveAllEmployees(); 
	Employe addEmployee(Employe en);
	void deleteEmployee(Long id);
	Employe updateEmployee(Employe en);
	Employe retrieveEmployee(Long id);
}
