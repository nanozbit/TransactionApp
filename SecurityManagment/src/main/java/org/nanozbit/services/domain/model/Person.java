package org.nanozbit.services.domain.model;

import lombok.Data;

@Data
public class Person {

    private long id;
    private String name;
    private String address;
    private String gender;
    private int age;
    private String identityDocument;
    private String cellphone;
}
