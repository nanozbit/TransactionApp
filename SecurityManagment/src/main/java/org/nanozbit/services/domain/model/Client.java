package org.nanozbit.services.domain.model;

import lombok.Data;

@Data
public class Client extends Person {

    private String password;
    private boolean status;

}
