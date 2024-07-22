package org.nanozbit.services.domain.model;

import lombok.Data;

@Data
public class Report {
    private String name;
    private String accountNumber;
    private String accountType;
    private Double totalTransaction;
}
