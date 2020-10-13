package com.example.exceptionhandling.exceptions;

public class BadNationalityException extends ExceptionBase {

    public BadNationalityException(String message , Object... args) {
        super(message);
        setArguments(args);
        setExceptionCode(ExceptionCode.BAD_NATIONALITY);
    }
}
