package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	private static final Logger l = LogManager.getLogger(EmployeeServiceImpl.class);

	@Override
	public List<Employe> retrieveAllEmployees() {
		List<Employe> employees = null;
		try {

			l.info("In Method retrieveAllEmployees :");
			employees = (List<Employe>) employeeRepository.findAll();
			l.debug("connexion à la DB Ok :");
			for (Employe employee : employees) {
				l.debug("employee :" + employee.getNom());
			}
			l.info("Out of Method retrieveAllEmployees with Success" + employees.size());
		} catch (Exception e) {
			l.error("Out of Method retrieveAllEmployees with Errors : " + e);
		}

		return employees;
	}

	@Override
	public Employe addEmployee(Employe en) {
		Employe e_saved = null;

		try {
			l.info("In Method addEmployee :");
			e_saved = employeeRepository.save(en);
			l.info("Out of Method addEmployee with Success" + e_saved.getNom());

		} catch (Exception e) {
			l.error("Out of Method addEmployee with Errors : " + e);
		}

		return e_saved;

	}

	@Override
	public void deleteEmployee(Long id) {
		try {
			l.info("In Method deleteEmployee :");
			employeeRepository.deleteById(id);
			l.info("Out of Method deleteEmployee with Success");

		} catch (Exception e) {
			l.error("Out of Method deleteEmployee with Errors : " + e);
		}
	}

	@Override
	public Employe updateEmployee(Employe en) {

		Employe employeeUpdated = null;

		try {
			l.info("In Method employeeUpdated :");
			employeeUpdated = employeeRepository.save(en);
			l.info("Out of Method employeeUpdated with Success" + employeeUpdated.getNom());

		} catch (Exception e) {
			l.error("Out of Method employeeUpdated with Errors : " + e);
		}

		return employeeUpdated;
	}

	@Override
	public Employe retrieveEmployee(Long id) {
		Optional<Employe> en = null;
		try {
			l.info("In Method retrieveEmployee :");
			en = employeeRepository.findById(id);
			if (en.isPresent()) {
				l.info("Out of Method retrieveEmployee with Success" + en.get().getNom());
				return en.get();
			}

		} catch (Exception e) {
			l.error("Out of Method retrieveEmployee with Errors : " + e);
		}
		return null;

	}

}
