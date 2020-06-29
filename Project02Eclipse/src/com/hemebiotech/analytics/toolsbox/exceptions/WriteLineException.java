package com.hemebiotech.analytics.toolsbox.exceptions;

public class WriteLineException extends Exception {
	
	/*
	 * Throw exception in case of the line has a problem to be written
	 */
	public WriteLineException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
