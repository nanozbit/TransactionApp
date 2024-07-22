package org.nanozbit.services.infrastructure.adapter.rest.modelView;

import lombok.Data;

@Data
public class ClientModelView {
    private long id;
    private String name;
    private String address;
    private String gender;
    private int age;
    private String identityDocument;
    private String cellphone;
    private String password;
    private boolean status;

}
