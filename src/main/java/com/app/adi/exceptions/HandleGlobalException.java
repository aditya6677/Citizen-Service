package com.app.adi.exceptions;

import ch.qos.logback.core.model.Model;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleGlobalException {

    @ExceptionHandler(CitizenNotFoundException.class)
    public ResponseEntity<String> handleException(CitizenNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
