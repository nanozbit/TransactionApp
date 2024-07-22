package org.nanozbit.services.application.service.Transaction;

import org.nanozbit.services.domain.model.Transaction;

public interface TransactionService {
    Iterable<Transaction> getTransactions();

    Transaction getTransaction(Long id);

    Transaction saveTransaction(Transaction transaction);

    void deleteTransaction(Long id);

    Transaction updateTransaction(long id, Transaction transaction);
}
