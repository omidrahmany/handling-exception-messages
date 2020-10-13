package com.example.exceptionhandling.exceptions;

import com.example.exceptionhandling.config.PropertiesHandler;
import com.example.exceptionhandling.servic.Response;
import com.example.exceptionhandling.servic.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    private Response<Object , Object> response = new Response<>();

    @Autowired
    private PropertiesHandler propertiesHandler;

    /*@org.springframework.web.bind.annotation.ExceptionHandler(value = {ExceptionBase.class , BadNationalityException.class} )
    public String handleMyException(Exception myException){
        System.out.println("it's handling MyException ...");
        return "exception handled!";
    }*/


    @org.springframework.web.bind.annotation.ExceptionHandler(ExceptionBase.class)
    protected ResponseEntity<Object> handleExceptionBase(ExceptionBase ex) {
        response.setInputArguments(ex.getArguments());
        response.setResponse(ExceptionModel.builder()
                .message(ex.getMessage() == null ? "" : propertiesHandler.getValue(ex.getMessage(), ex.getArguments()))
                .stackTrace(ex.getStackTrace())
                .code(ex.getCode())
                .exceptionCode(ex.getExceptionCode())
                .build());
        response.setCode(ResponseCode.EXCEPTION);
        System.out.println("test exception thrown...");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
