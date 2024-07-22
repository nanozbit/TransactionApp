package org.nanozbit.services.infrastructure.adapter.repository.Transaction;


import org.nanozbit.services.infrastructure.adapter.repository.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionJpaRepository extends JpaRepository<TransactionEntity, Long> {
    @Query("SELECT t FROM transaction t ORDER BY t.transactionDate DESC")
    List<TransactionEntity> findAllByTransactionDateDesc();
}
