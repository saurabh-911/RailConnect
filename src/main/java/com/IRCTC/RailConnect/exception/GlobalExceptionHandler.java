package com.IRCTC.RailConnect.exception;

import com.IRCTC.RailConnect.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TrainNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchElementException(TrainNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), "404", false);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        Map<String,String> errorResponse = new HashMap<>();

        methodArgumentNotValidException
        .getBindingResult()
        .getFieldErrors()
        .forEach(error -> {
            errorResponse.put(error.getField(), error.getDefaultMessage());
        });

//        methodArgumentNotValidException
//                .getBindingResult()
//                .getAllErrors()
//                .forEach(error -> {
//            String errorMessage = error.getDefaultMessage();
//            String errorField = ((FieldError) error).getField();
//            errorResponse.put(errorField, errorMessage);
//        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
