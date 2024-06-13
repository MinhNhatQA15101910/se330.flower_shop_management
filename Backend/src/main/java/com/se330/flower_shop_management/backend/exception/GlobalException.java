package com.se330.flower_shop_management.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = "Validation error";

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errorMessage = error.getDefaultMessage();
            break;
        }

        Map<String, String> response = new HashMap<>();
        response.put("msg", errorMessage);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
