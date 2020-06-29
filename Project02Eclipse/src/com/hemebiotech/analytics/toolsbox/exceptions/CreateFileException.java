package com.hemebiotech.analytics.toolsbox.exceptions;

public class CreateFileException extends Exception {
	
	/*
	 * Throw exception in case of the file has a problem to be created
	 */
	public CreateFileException(String message, Throwable cause) {
		super(message, cause);
	}

}
