package com.istio.core1.sample.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

/**
 * TestAdvice
 */
@ControllerAdvice
public class TestAdvice {

    @ExceptionHandler(value = { TestException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    protected Map<String, String> handleConflict(RuntimeException ex, WebRequest request) {
        Map<String, String> result = new HashMap<>();

        result.put("status", HttpStatus.INTERNAL_SERVER_ERROR.toString());
        result.put("message", ex.getMessage());
        return result;
    }
}