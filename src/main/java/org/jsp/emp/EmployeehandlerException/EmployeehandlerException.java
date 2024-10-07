package org.jsp.emp.EmployeehandlerException;

import org.jsp.emp.ExceptionClasses.InvalidCredentialsExceptions;
import org.jsp.emp.ExceptionClasses.InvalidEmployeeIdException;
import org.jsp.emp.ExceptionClasses.InvalidEmployeeNameException;
import org.jsp.emp.ExceptionClasses.NoActiveEmployeesFoundException;
import org.jsp.emp.ResponseStructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeehandlerException {
	@ExceptionHandler(NoActiveEmployeesFoundException.class)
	public ResponseEntity<String> NoActiveEmployeesFoundException(NoActiveEmployeesFoundException e) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("No Active Employees ");
		structure.setBody(e.getMessage());
		return new ResponseEntity(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidCredentialsExceptions.class)
	public ResponseEntity InvalidEmployeeIdException(InvalidCredentialsExceptions e) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Invalid Credientials Place Give Valid Credentials");
		structure.setBody(e.getMessage());
		return new ResponseEntity(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidEmployeeIdException.class)
	public ResponseEntity<String> InvalidEmployeeIdException(InvalidEmployeeIdException e) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Invalid Employee Id");
		structure.setBody(e.getMessage());
		return new ResponseEntity(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidEmployeeNameException.class)
	public ResponseEntity<ResponseStructure<String>> InvalidEmployeeIdException(InvalidEmployeeNameException e) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Invalid Employee Name Place Enter Valid Name..");
		structure.setBody(e.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

}
