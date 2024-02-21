package com.sellcontrol.sellcontrolapi.infra.exception;

public class CreateException extends RuntimeException{
    public CreateException(String message) {
        super(message);
    }
}
