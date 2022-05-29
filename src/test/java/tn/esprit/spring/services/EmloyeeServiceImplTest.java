package tn.esprit.spring.services;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EmloyeeServiceImplTest {
	@Autowired
	private IEmployeeService employeeService;
	
	@Test
	@Order(1)
	public void testRetrieveAllEmployees() {
		List<Employe> listEmployees = employeeService.retrieveAllEmployees();
		Assertions.assertEquals(0, listEmployees.size());
	}
	
	@Test
	@Order(2)
	public void testAddEmployee() throws ParseException {
		Employe emp = new Employe("Dridi","Nouhaila","nouhaila@mail.com","password",true,Role.INGENIEUR);
		Employe employeeAdded = employeeService.addEmployee(emp);
		Assertions.assertEquals(emp.getNom(), employeeAdded.getNom());
	}
	

	@Test
	@Order(3)
	public void testUpdateEmployee () throws ParseException {
		Employe emp = new Employe(1L,"Nouhaila2","Dridi","nouhaila@mail.com","password",true,Role.INGENIEUR);
		Employe employeeUpdated = employeeService.updateEmployee(emp);
		Assertions.assertEquals(emp.getNom(), employeeUpdated.getNom());
	} 
	
	@Test
	@Order(4)
	public void testRetrieveEmployee() throws ParseException {
		Employe employeeRetreived = employeeService.retrieveEmployee(1L);
		
		Assertions.assertEquals(1L, employeeRetreived.getId());
	}
	
	
	@Test
	@Order(5)
    public void testDeleteEmployee() throws ParseException {
		employeeService.deleteEmployee(1L);
		Assertions.assertEquals(0, employeeService.retrieveAllEmployees().size());
	}
	

}
