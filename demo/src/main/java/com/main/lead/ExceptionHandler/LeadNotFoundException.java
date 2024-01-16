package com.main.lead.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class LeadNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

	public LeadNotFoundException(String message) {
        super(message);
    }
}
