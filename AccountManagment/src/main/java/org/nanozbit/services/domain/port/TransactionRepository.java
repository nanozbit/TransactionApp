package org.nanozbit.services.domain.port;


import org.nanozbit.services.domain.model.Transaction;
import org.nanozbit.services.infrastructure.adapter.repository.entity.TransactionEntity;

import java.util.Optional;

public interface TransactionRepository {
    Iterable<TransactionEntity> getTransactions();

    Transaction getTransaction(Long id);

    Transaction saveTransaction(TransactionEntity transaction);

    void deleteTransaction(Long id);

    Transaction updateTransaction(long id, TransactionEntity transaction);
    Double getLastSales(TransactionEntity transaction);
}
