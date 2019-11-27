package com.nf.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceExeption {

    @ExceptionHandler(RuntimeException.class)
    public String handlerRuntime(){
        return "error";
    }
}
