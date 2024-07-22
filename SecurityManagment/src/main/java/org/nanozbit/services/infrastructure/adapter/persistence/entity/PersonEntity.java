package org.nanozbit.services.infrastructure.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name="person")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private String gender;
    private int age;
    private String identityDocument;
    private String cellphone;

}
