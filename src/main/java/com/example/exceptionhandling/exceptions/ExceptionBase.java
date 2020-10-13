package com.example.exceptionhandling.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionBase extends RuntimeException {

    private String code;
    private String message;
    private Object[] arguments;
    private ExceptionCode exceptionCode;

    public ExceptionBase(String message) {
//        super(message);  // wrong & redundant code!
        this.message = message;
    }

    public ExceptionBase(String message, boolean isInfrastructureMessage) {
        super(message);
    }

    public ExceptionBase(String message, Throwable cause){
        super(message, cause);
    }

    public ExceptionBase(Throwable cause){
        super(cause);
    }

    public ExceptionBase(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
