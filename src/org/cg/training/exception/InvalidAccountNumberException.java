package org.cg.training.exception;

/**
 * Custom exception for Invalid account no
 * 
 * @author njasani
 *
 */
public class InvalidAccountNumberException extends Exception {

	public InvalidAccountNumberException() {
		super();
	}

	public InvalidAccountNumberException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidAccountNumberException(String message, Throwable cause) {
		super(message, cause);
	}
}
