package org.jsp.emp.ExceptionClasses;

import lombok.Builder;

@Builder
public class InvalidEmployeeIdException extends RuntimeException {
	private String message;

	public InvalidEmployeeIdException() {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

	
}
