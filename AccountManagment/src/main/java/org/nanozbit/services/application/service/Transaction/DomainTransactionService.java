package org.nanozbit.services.application.service.Transaction;

import org.nanozbit.services.application.service.account.AccountService;
import org.nanozbit.services.domain.model.Transaction;
import org.nanozbit.services.domain.port.TransactionRepository;
import org.nanozbit.services.infrastructure.adapter.mapper.TransactionMapper;
import org.springframework.stereotype.Service;

@Service
public class DomainTransactionService implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    private final AccountService accountService;


    public DomainTransactionService(TransactionRepository transactionRepository,
                                    TransactionMapper transactionMapper,
                                    AccountService accountService) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
        this.accountService = accountService;
    }

    @Override
    public Iterable<Transaction> getTransactions() {
        var accounts = this.transactionRepository.getTransactions();
        return this.transactionMapper.toTransactions(accounts);
    }

    @Override
    public Transaction getTransaction(Long id) {
        return this.transactionRepository.getTransaction(id);
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        var account = this.accountService.getAccount(
                transaction.getAccount().getId(),
                transaction.getAccount().getAccountNumber());
        transaction.setAccount(account);
        var transactionEntity = this.transactionMapper.toTransactionEntity(transaction);
        var sale = this.transactionRepository.getLastSales(transactionEntity);
        transaction.setSales(sale);
        transaction.setAccount(null);
        account.getTransactions().add(transaction);
        var result = this.accountService.saveAccount(account);
        result.setTransactions(null);
        transaction.setAccount(result);
        return transaction;
    }

    @Override
    public void deleteTransaction(Long id) {
        this.transactionRepository.deleteTransaction(id);
    }

    @Override
    public Transaction updateTransaction(long id, Transaction transaction) {
        var account = this.accountService.getAccount(transaction.getAccount().getId());
        account.setTransactions(null);
        transaction.setAccount(account);
        var transactionEntiy = this.transactionMapper.toTransactionEntity(transaction);
        return this.transactionRepository.updateTransaction(id, transactionEntiy);

    }
}
