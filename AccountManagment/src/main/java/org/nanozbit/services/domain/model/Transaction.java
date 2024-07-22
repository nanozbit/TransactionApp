package org.nanozbit.services.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Transaction {
    private long id;
    private LocalDateTime transactionDate;
    private String transactionType;
    private double value;
    private double sales;
    private Account Account;
}
