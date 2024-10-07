package org.jsp.emp.ExceptionClasses;

public class InvalidCredentialsExceptions extends RuntimeException {
	private String message;

	public void InvalidEmployeeIdException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
