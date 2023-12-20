package com.team5.exceptions;

import java.io.Serial;

public class InvalidCredentialsException extends RuntimeException{
	

	@Serial
	private static final long serialVersionUID = 8421506804341692775L;

	public InvalidCredentialsException(String message) {
		super(message);
	}

}
