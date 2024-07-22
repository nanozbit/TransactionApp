package org.nanozbit.services.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class Account {
    private long id;
    private long clientId;
    private String name;
    private String accountNumber;
    private String accountType;
    private double initialBalance;
    private double lastBalance;
    private boolean status;
    private List<Transaction> transactions;
}
