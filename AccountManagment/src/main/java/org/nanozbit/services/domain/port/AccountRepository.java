package org.nanozbit.services.domain.port;


import org.nanozbit.services.domain.model.Account;
import org.nanozbit.services.domain.model.Report;
import org.nanozbit.services.infrastructure.adapter.repository.entity.AccountEntity;

import java.time.LocalDateTime;

public interface AccountRepository {
    Iterable<AccountEntity> getAccounts();

    Iterable<Report> getReport(LocalDateTime initialDate, LocalDateTime endDate);

    Account getAccount(Long id);
    Account getAccount(Long id, String accountNumber);
    Account saveAccount(AccountEntity account);

    void deleteAccount(Long id);

    Account updateAccount(AccountEntity account);
}
