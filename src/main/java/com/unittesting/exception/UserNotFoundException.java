package com.unittesting.exception;

/**
 * The Class UserNotFoundException throws a run time exception.
 * 
 * @author dhkannan
 * @since 21.02
 */
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
