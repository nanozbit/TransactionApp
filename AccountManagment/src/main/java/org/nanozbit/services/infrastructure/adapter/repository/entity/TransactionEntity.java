package org.nanozbit.services.infrastructure.adapter.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name = "transaction")
@Data
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime transactionDate;
    private String transactionType;
    private double value;
    private double sales;
    @ManyToOne
    private AccountEntity account;

}
