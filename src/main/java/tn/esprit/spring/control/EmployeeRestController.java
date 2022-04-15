package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.IEmployeeService;

//employeeRestControl
@RestController // = @Controller + @ResponseBody 
//@Scope("session") 
//singleton c'est par défaut 
//prototype 
//request 
public class EmployeeRestController {
	// Couplage Faible 
	@Autowired 
	IEmployeeService employeeService; 

	// URL : http://localhost:????/????/retrieve-all-employees
			@GetMapping("/retrieve-all-employees")
			public List<Employe> retrieveAllEmployees() {
				List<Employe> list = employeeService.retrieveAllEmployees();
				return list;
			}
		 
			// http://localhost:????/timesheet-devops/retrieve-employee/{employee-id}
			@GetMapping("/retrieve-employee/{employee-id}")
			public Employe retrieveEmployee(@PathVariable("employee-id") Long employeeId) {
				return employeeService.retrieveEmployee(employeeId);
			}

			// Ajouter employee : http://localhost:????/timesheet-devops/add-employee 
			@PostMapping("/add-employee")
			public Employe addEmployee(@RequestBody Employe en) {
				Employe employee = employeeService.addEmployee(en); 
				return employee;
			}

			
			// Supprimer employee : 
			// http://localhost:????/timesheet-devops/remove-employee/{employee-id}
			@DeleteMapping("/remove-employee/{employee-id}") 
			public void removeEmployee(@PathVariable("employee-id") Long employeeId) { 
				employeeService.deleteEmployee(employeeId);
			} 
			// Modifier employee 
			// http://localhost:????/timesheet-devops/modify-employee 
			@PutMapping("/modify-employee") 
			public Employe updateEmployee(@RequestBody Employe employee) {
				return employeeService.updateEmployee(employee);
			}
}
