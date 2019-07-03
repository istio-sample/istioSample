package com.istio.core1.sample.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * TestException
 */
@Data
@AllArgsConstructor
public class TestException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String message;
}