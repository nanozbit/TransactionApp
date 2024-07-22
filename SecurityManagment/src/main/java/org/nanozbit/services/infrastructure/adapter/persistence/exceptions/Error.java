package org.nanozbit.services.infrastructure.adapter.persistence.exceptions;

import lombok.Data;

@Data
public class Error {
    private String code;
    private String message;

}
