package com.example.backend.exception;

import lombok.Getter;

/**
 * customized exception for service layer
 */
@Getter
public class ServiceException extends RuntimeException {
    private String code;

    public ServiceException(String code, String msg) {
        super(msg);
        this.code = code;
    }

}
