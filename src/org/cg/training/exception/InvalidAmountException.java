package org.cg.training.exception;

/**
 * Custom exception for Invalid transaction amount
 * 
 * @author njasani
 *
 */
public class InvalidAmountException extends Exception {

	public InvalidAmountException() {
		super();
	}

	public InvalidAmountException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidAmountException(String message, Throwable cause) {
		super(message, cause);
	}
}
