package org.jsp.emp.Service;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.Dao.EmployeeDao;
import org.jsp.emp.Entity.Employee;
import org.jsp.emp.ExceptionClasses.InvalidCredentialsExceptions;
import org.jsp.emp.ExceptionClasses.InvalidEmployeeIdException;
import org.jsp.emp.ExceptionClasses.InvalidEmployeeNameException;
import org.jsp.emp.ExceptionClasses.NoActiveEmployeesFoundException;
import org.jsp.emp.ResponseStructure.ResponseStructure;
import org.jsp.emp.util.EmployeeStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {
	@Autowired
	private EmployeeDao dao;

	public ResponseEntity<?> saveEmployee(Employee employee) {
		employee.setStatus(EmployeeStatus.IN_ACTIVE);
		employee = dao.saveEmployee(employee);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.CREATED.value());
//		structure.setMessage("Employee Details saved Successfully............");
//		structure.setBody(employee);
//		return structure;
		return ResponseEntity.status(HttpStatus.FOUND.value())
				.body(ResponseStructure.builder().status(HttpStatus.FOUND.value())
						.message("Employee Details Saved Successfully.........").body(employee).build());
	}

	public ResponseEntity<?> updateEmployee(Employee employee) {
		employee = dao.updateEmployee(employee);
//		ResponseStructure<Employee> structure = new ResponseStructure<>();
//		structure.setStatus(HttpStatus.OK.value());
//		structure.setMessage("Employee Details Updated Successfully............");
//		structure.setBody(employee);
//		return structure;

		return ResponseEntity.status(HttpStatus.FOUND.value())
				.body(ResponseStructure.builder().status(HttpStatus.FOUND.value())
						.message("Employees Updated SuccessFully..........").body(employee).build());

	}

	public ResponseEntity<?> findEmployeeById(int id) {
		Optional<Employee> optional = dao.findEmployeeById(id);
//		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		if (optional.isEmpty()) {
			throw InvalidEmployeeIdException.builder().message("Invalid Employee ID").build();
		}
		Employee employees = optional.get();

		return ResponseEntity.status(HttpStatus.FOUND.value()).body(ResponseStructure.builder()
				.status(HttpStatus.FOUND.value()).message("Employees Found Successfully").body(employees).build());

//		return ResponseEntity.status(HttpStatus.FOUND.value()).body(ResponseStructure.builder())
//				.status(HttpStatus.CREATED.value()).message("employee Found ").body(employee).build());

//		structure.setStatus(HttpStatus.OK.value());
//		structure.setMessage("Employee Id verifies Successfully............");
//		structure.setBody(employee);
//		return structure;
	}

	public ResponseEntity<?> findAllEmployee() {
		List<Employee> employees = dao.findAllActiveEmployee();
//		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();

		if (employees.isEmpty()) {
			throw new NoActiveEmployeesFoundException();
		}

//		ArrayList<Employee> activeEmployee = new ArrayList<Employee>();
//		for (Employee e : employees) {
//			if (e.getStatus() == EmployeeStatus.ACTIVE) {
//				activeEmployee.add(e);
//			}
//		}

//		structure.setStatus(HttpStatus.OK.value());
//		structure.setMessage("All Employee Found..........");
//		structure.setBody(employees);
//		return structure;
		return ResponseEntity.status(HttpStatus.FOUND.value()).body(ResponseStructure.builder()
				.status(HttpStatus.FOUND.value()).message("Employees Found Successfully").body(employees).build());
	}

	public ResponseEntity<?> deleteEmployeeById(int id) {
		Optional<Employee> optional = dao.findEmployeeById(id);
//		ResponseStructure<String> structure = new ResponseStructure<>();

		if (optional.isEmpty()) {
			throw new InvalidEmployeeIdException();
		}
		dao.deleteEmployeeById(id);
		Employee employee = optional.get();
		return ResponseEntity.status(HttpStatus.FOUND.value())
				.body(ResponseStructure.builder().status(HttpStatus.FOUND.value())
						.message("employee Found And Deleted Successfully..............").body(employee).build());
	}

	public ResponseEntity<?> findEmployeeByEmailAndPassword(String email, String password) {
//		ResponseStructure<Employee> structure = new ResponseStructure<>();
		Optional<Employee> optional = dao.findEmploeeByEmailAndPassword(email, password);

		if (optional.isEmpty()) {
			throw new InvalidCredentialsExceptions();
		}
		Employee employee = optional.get();
//		structure.setStatus(HttpStatus.OK.value());
//		structure.setMessage("Verification Successfull.....................");
//		structure.setBody(employee);
//		return structure;
//		return ResponseEntity.status(HttpStatus.FOUND.value()).body(ResponseStructure.builder()
//				.status(HttpStatus.FOUND.value()).message("Employee found").body(employee).build());
		return ResponseEntity.status(HttpStatus.FOUND.value())
				.body(ResponseStructure.builder().status(HttpStatus.FOUND.value())
						.message("Employee Crediential Verified SuccessFully.....").body(employee).build());
	}

	public ResponseEntity<?> findEmployeeByname(String name) {
		List<Employee> employee = dao.findEmployeeByName(name);
//		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		if (employee.isEmpty()) {
			throw new InvalidEmployeeNameException();
		}
//		structure.setStatus(HttpStatus.OK.value());
//		structure.setMessage("Employee found...............");
//		structure.setBody(employee);
//		return structure;

		return ResponseEntity.status(HttpStatus.FOUND.value()).body(ResponseStructure.builder()
				.status(HttpStatus.FOUND.value()).message("Employees Found ").body(employee).build());

	}

	public ResponseEntity<?> setEmployeeStatusToactive(int id) {
		Optional<Employee> optional = dao.findEmployeeById(id);
//		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();

		if (optional.isEmpty()) {
			throw new InvalidEmployeeIdException();
		}
		Employee employee = optional.get();
		employee.setStatus(EmployeeStatus.ACTIVE);
		employee = dao.updateEmployee(employee);

		return ResponseEntity.status(HttpStatus.FOUND.value())
				.body(ResponseStructure.builder().status(HttpStatus.FOUND.value())
						.message("employee Found And Actived Successfully..............").body(employee).build());

//		structure.setStatus(HttpStatus.OK.value());
//		structure.setMessage("Employee Status Updated to Active SuccessFully.....");
//		structure.setBody(employee);
//		return structure;
	}

	public ResponseEntity<?> SetEmployeeStatusToInactive(int id) {
		Optional<Employee> optional = dao.findEmployeeById(id);
//		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();

		if (optional.isEmpty()) {
			throw new InvalidEmployeeIdException();
//			structure.setStatus(HttpStatus.BAD_REQUEST.value());
//			structure.setMessage("Invalid Employee Id.... Unable to make In_Active");
//			structure.setBody(null);
//			return structure;
		}
		Employee employee = optional.get();
		employee.setStatus(EmployeeStatus.IN_ACTIVE);
		employee = dao.updateEmployee(employee);

		return ResponseEntity.status(HttpStatus.FOUND.value())
				.body(ResponseStructure.builder().status(HttpStatus.FOUND.value())
						.message("employee Found And Changed In_Active Successfully..............").body(employee)
						.build());

//		structure.setStatus(HttpStatus.OK.value());
//		structure.setMessage("Employee Status Updated to In_Active SuccessFully.....");
//		structure.setBody(employee);
//		return structure;

	}
}
