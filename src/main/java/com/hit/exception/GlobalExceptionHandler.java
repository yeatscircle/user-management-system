package com.hit.exception;

import com.hit.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result exceptionDisplay(Exception e){
        e.printStackTrace();
        return Result.error("程序错误");
    }
}
