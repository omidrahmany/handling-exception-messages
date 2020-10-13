package com.example.exceptionhandling.exceptions;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ExceptionModel {
    private String message;
    private Object stackTrace;
    private String code;
    private ExceptionCode exceptionCode;
}
