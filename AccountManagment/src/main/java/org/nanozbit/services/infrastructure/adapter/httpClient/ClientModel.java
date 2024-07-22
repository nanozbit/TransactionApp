package org.nanozbit.services.infrastructure.adapter.httpClient;

import lombok.Data;

@Data
public class ClientModel {
    private long id;
    private String name;
    private String address;
    private String gender;
    private int age;
    private String identityDocument;
    private String cellphone;
    private boolean status;
    private String password;

}
