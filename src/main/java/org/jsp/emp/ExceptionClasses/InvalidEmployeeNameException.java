package org.jsp.emp.ExceptionClasses;

public class InvalidEmployeeNameException extends RuntimeException {
	private String message;

	public InvalidEmployeeNameException() {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
