package com.sellcontrol.sellcontrolapi.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandling {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleError404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleError400(MethodArgumentNotValidException ex){

        var errors = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(errors.stream().map(DataErrorValidation::new).toList());
    }

    //Dto tratamento de erro 400

    private record DataErrorValidation(String field, String message){

        public DataErrorValidation(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }

}
