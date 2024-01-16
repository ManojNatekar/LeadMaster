package com.main.lead.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> handleConstraintViolation(ConstraintViolationException ex) {
		Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
		List<String> errorMessages = new ArrayList<>();
		for (ConstraintViolation<?> violation : violations) {
			errorMessages.add(violation.getMessage());
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body("Please proved correct data as: " + String.join(", ", errorMessages));
	}
	
	@ExceptionHandler(LeadNotFoundException.class)
    public ResponseEntity<String> handleLeadNotFoundException(LeadNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
