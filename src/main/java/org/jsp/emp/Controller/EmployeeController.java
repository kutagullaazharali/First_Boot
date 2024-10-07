package org.jsp.emp.Controller;

import org.jsp.emp.Entity.Employee;
import org.jsp.emp.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@PostMapping("/employee")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	@PutMapping("/employee")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}

	@GetMapping("/employee")
	public ResponseEntity<?> findAllEmployee() {
		return service.findAllEmployee();
	}

	@GetMapping("/employee/name/{name}")
	public ResponseEntity<?> findEmployeeByname(@PathVariable String name) {

		return service.findEmployeeByname(name);
	}

	@GetMapping("/employee/{email}/{password}")
	public ResponseEntity<?> findEmployeeByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
		return service.findEmployeeByEmailAndPassword(email, password);
	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<?> DeleteEmployeeByid(@PathVariable int id) {
		return service.deleteEmployeeById(id);
	}

	@PatchMapping("/employee/active/{id}")
	public ResponseEntity<?> setEmployeeStatusToactive(@PathVariable int id) {
		return service.setEmployeeStatusToactive(id);
	}

	@PatchMapping("/employee/inactive/{id}")
	public ResponseEntity<?> SetEmployeeStatusToInactive(@PathVariable int id) {
		return service.SetEmployeeStatusToInactive(id);
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<?> findEmployeeById(@PathVariable int id) {
		return service.findEmployeeById(id);
	}
}
