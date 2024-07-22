package org.nanozbit.services.infrastructure.adapter.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "account")
@Data
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "client_id")
    private long clientId;
    private String name;
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "initial_balance")
    private double initialBalance;
    @Column(name = "last_balance")
    private double lastBalance;
    @Column(name = "status")
    private boolean status;

    @OneToMany(targetEntity = TransactionEntity.class, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<TransactionEntity> transactions;
}
