package org.nanozbit.services.infrastructure.adapter.repository.Transaction;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.nanozbit.services.domain.model.Transaction;
import org.nanozbit.services.domain.port.TransactionRepository;
import org.nanozbit.services.infrastructure.adapter.mapper.TransactionMapper;
import org.nanozbit.services.infrastructure.adapter.repository.entity.TransactionEntity;
import org.nanozbit.services.infrastructure.adapter.repository.exceptions.TransactionException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

@Repository
@Slf4j
@Transactional
public class TransactionRepositoryMysql implements TransactionRepository {
    private final TransactionJpaRepository transactionJpaRepository;
    private final TransactionMapper transactionMapper;

    public TransactionRepositoryMysql(TransactionJpaRepository transactionJpaRepository,
                                      TransactionMapper transactionMapper) {
        this.transactionJpaRepository = transactionJpaRepository;
        this.transactionMapper = transactionMapper;
    }


    @Override
    public Iterable<TransactionEntity> getTransactions() {
        return this.transactionJpaRepository.findAll();
    }

    @Override
    public Transaction getTransaction(Long id) {
        try {
            var account = this.transactionJpaRepository.findById(id).orElseThrow();
            return this.transactionMapper.toTransaction(account);
        } catch (NoSuchElementException e) {
            throw new TransactionException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @Override
    public Transaction saveTransaction(TransactionEntity transaction) {

        Double lastSale = 0.0;
        try {
            var transactionEntity = this.transactionJpaRepository.findAllByTransactionDateDesc()
                    .stream().
                    findFirst()
                    .orElseThrow();
            lastSale = transactionEntity.getSales();
        } catch (NoSuchElementException e) {
            lastSale = transaction.getAccount().getInitialBalance();
        }

        if (lastSale < Math.abs(transaction.getValue())) {
            throw new TransactionException(HttpStatus.NOT_ACCEPTABLE, "Saldo Insuficiente");
        }
        if (lastSale == 0)

            lastSale += transaction.getValue();
        transaction.setSales(lastSale);

        var resultTransaction = this.transactionJpaRepository.save(transaction);
        return this.transactionMapper.toTransaction(resultTransaction);

    }

    public Double getLastSales(TransactionEntity transaction) {

        Double lastSale = 0.0;
        try {
            var transactionEntity = this.transactionJpaRepository.findAllByTransactionDateDesc()
                    .stream().
                    findFirst()
                    .orElseThrow();
            lastSale = transactionEntity.getSales();
        } catch (NoSuchElementException e) {
            lastSale = transaction.getAccount().getInitialBalance();
        }

        lastSale += transaction.getValue();

        if (lastSale < 0) {
            throw new TransactionException(HttpStatus.NOT_ACCEPTABLE, "Saldo Insuficiente");
        }

        transaction.setSales(lastSale);

        return transaction.getSales();

    }

    @Override
    public void deleteTransaction(Long id) {
        this.transactionJpaRepository.deleteById(id);
    }

    @Override
    public Transaction updateTransaction(long id, TransactionEntity transaction) {
        transaction.setId(id);
        var transactionEntity = this.transactionJpaRepository.save(transaction);
        transactionEntity.getAccount().setTransactions(null);
        return this.transactionMapper.toTransaction(transactionEntity);
    }
}
