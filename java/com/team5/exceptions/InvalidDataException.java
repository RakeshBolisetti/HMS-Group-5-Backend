package com.team5.exceptions;

import java.io.Serial;

public class InvalidDataException extends RuntimeException {

    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 8421506804341692775L;


    public InvalidDataException(String message) {
        super(message);
    }

}
