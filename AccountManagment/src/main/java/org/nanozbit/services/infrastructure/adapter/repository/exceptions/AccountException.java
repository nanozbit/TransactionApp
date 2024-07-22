package org.nanozbit.services.infrastructure.adapter.repository.exceptions;

import org.springframework.http.HttpStatus;

import java.util.NoSuchElementException;

public class AccountException extends NoSuchElementException {

    private static final long serialVersionUID = 1L;

    private HttpStatus errorCode;
    private String errorMessage;

    public AccountException(HttpStatus errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public AccountException() {
    }

    public HttpStatus getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(HttpStatus errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
