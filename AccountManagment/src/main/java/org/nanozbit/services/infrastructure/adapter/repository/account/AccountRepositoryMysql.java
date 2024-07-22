package org.nanozbit.services.infrastructure.adapter.repository.account;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.nanozbit.services.domain.model.Account;
import org.nanozbit.services.domain.model.Report;
import org.nanozbit.services.domain.port.AccountRepository;
import org.nanozbit.services.infrastructure.adapter.mapper.AccountMapper;
import org.nanozbit.services.infrastructure.adapter.repository.JdbcRepository.ReportJdbRepository;
import org.nanozbit.services.infrastructure.adapter.repository.entity.AccountEntity;
import org.nanozbit.services.infrastructure.adapter.repository.exceptions.AccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Repository
@Slf4j
@Transactional
public class AccountRepositoryMysql implements AccountRepository {
    private final AccountJpaRepository accountJpaRepository;

    private final AccountMapper accountMapper;

    @Autowired
    private ReportJdbRepository reportJdbRepository;

    public AccountRepositoryMysql(AccountJpaRepository accountJpaRepository, AccountMapper accountMapper) {
        this.accountJpaRepository = accountJpaRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public Iterable<AccountEntity> getAccounts() {
        return this.accountJpaRepository.findAll();
    }

    @Override
    public Iterable<Report> getReport(LocalDateTime initialDate, LocalDateTime endDate) {
        return this.reportJdbRepository.getReport(initialDate, endDate);
    }

    @Override
    public Account getAccount(Long id) {
        try {
            var account = this.accountJpaRepository.findById(id).orElseThrow();
            return this.accountMapper.toAccount(account);
        } catch (NoSuchElementException e) {
            throw new AccountException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public Account getAccount(Long id, String accountNumber) {
        try {
            var account = this.accountJpaRepository.findByClientIdAndAccountNumber(id, accountNumber)
                    .stream().findFirst().get();
            return this.accountMapper.toAccount(account);
        } catch (NoSuchElementException e) {
            throw new AccountException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public Account saveAccount(AccountEntity account) {
        var accountResponse = this.accountJpaRepository.save(account);
        return this.accountMapper.toAccount(accountResponse);
    }

    @Override
    public void deleteAccount(Long id) {
        this.accountJpaRepository.deleteById(id);
    }

    @Override
    public Account updateAccount(AccountEntity account) {
        var accountResult = this.accountJpaRepository.save(account);
        return this.accountMapper.toAccount(accountResult);
    }
}
