package org.cg.training.exception;

/**
 * Custom exception for Invalid transaction amount
 * 
 * @author njasani
 *
 */
public class InsufficientBalanceException extends Exception {

	public InsufficientBalanceException() {
		super();
	}

	public InsufficientBalanceException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InsufficientBalanceException(String message, Throwable cause) {
		super(message, cause);
	}
}
