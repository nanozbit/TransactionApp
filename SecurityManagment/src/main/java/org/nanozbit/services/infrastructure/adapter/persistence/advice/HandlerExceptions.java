package org.nanozbit.services.infrastructure.adapter.persistence.advice;

import org.nanozbit.services.infrastructure.adapter.persistence.exceptions.ClientException;
import org.nanozbit.services.infrastructure.adapter.persistence.exceptions.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerExceptions {


    @ExceptionHandler(ClientException.class)
    public ResponseEntity<Error> handle(ClientException e){
        Error error = new Error();
        error.setCode(HttpStatus.NOT_FOUND.name());
        error.setMessage(e.getErrorMessage());
        return  new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
