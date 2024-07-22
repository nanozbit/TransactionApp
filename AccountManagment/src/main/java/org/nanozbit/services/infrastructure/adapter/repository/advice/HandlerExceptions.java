package org.nanozbit.services.infrastructure.adapter.repository.advice;

import org.nanozbit.services.infrastructure.adapter.repository.exceptions.AccountException;
import org.nanozbit.services.infrastructure.adapter.repository.exceptions.Error;
import org.nanozbit.services.infrastructure.adapter.repository.exceptions.TransactionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerExceptions {


    @ExceptionHandler(AccountException.class)
    public ResponseEntity<Error> handle(AccountException e) {
        Error error = new Error();
        error.setCode(HttpStatus.CONFLICT.name());
        error.setMessage("Exception Account Service");
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(TransactionException.class)
    public ResponseEntity<Error> handleTransaction(TransactionException e) {
        Error error = new Error();
        error.setCode(HttpStatus.CONFLICT.name());
        error.setMessage("Exception Transaction Service");
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

}
