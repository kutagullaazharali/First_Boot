package org.jsp.emp.ExceptionClasses;

public class NoActiveEmployeesFoundException extends RuntimeException {
	private String message;

	public NoActiveEmployeesFoundException() {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
