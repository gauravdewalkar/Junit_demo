package com.unittesting.exception;

import java.util.Date;

/**
 * The Class ExceptionFormat is the customized format for all the Exceptions
 * thrown in this project.
 * 
 * @author dhkannan
 * @since 21.02
 */
public class ExceptionFormat {
	private Date timestamp;
	private String message;
	private String details;

	public ExceptionFormat(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

}