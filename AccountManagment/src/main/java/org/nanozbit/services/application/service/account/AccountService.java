package org.nanozbit.services.application.service.account;

import org.nanozbit.services.domain.model.Account;
import org.nanozbit.services.domain.model.Report;

import java.time.LocalDateTime;

public interface AccountService {
    Iterable<Account> getAccounts();
    Iterable<Report> getReport(LocalDateTime initialDate, LocalDateTime endDate);

    Account getAccount(Long id);
    Account getAccount(Long id, String accountNumber);

    Account saveAccount(Account account);

    void deleteAccount(Long id);

    Account updateAccount(long id, Account account);
}
