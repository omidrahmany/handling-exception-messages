package com.example.exceptionhandling.exceptions;

public class EntityNotFoundException extends ExceptionBase {

    public EntityNotFoundException(String message , Object... args) {
        super(message);
        setExceptionCode(ExceptionCode.NOT_FOUND);
        setArguments(args);
    }
}
