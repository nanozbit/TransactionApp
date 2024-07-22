package org.nanozbit.services.infrastructure.adapter.persistence.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity(name = "client")
@Data
public class ClientEntity extends PersonEntity {
    private String password;
    private boolean status;
}
