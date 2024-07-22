package org.nanozbit.services.application.service.account;

import org.nanozbit.services.domain.model.Account;
import org.nanozbit.services.domain.model.Report;
import org.nanozbit.services.domain.port.AccountRepository;
import org.nanozbit.services.infrastructure.adapter.httpClient.ClientHttpClient;
import org.nanozbit.services.infrastructure.adapter.httpClient.ClientModel;
import org.nanozbit.services.infrastructure.adapter.mapper.AccountMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DomainAccountService implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final ClientHttpClient clientHttp;

    public DomainAccountService(AccountRepository accountRepository,
                                AccountMapper accountMapper,
                                ClientHttpClient clientHttp) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
        this.clientHttp = clientHttp;
    }

    @Override
    public Iterable<Account> getAccounts() {
        var accounts = this.accountRepository.getAccounts();
        return this.accountMapper.toAccounts(accounts);
    }

    @Override
    public Iterable<Report> getReport(LocalDateTime initialDate, LocalDateTime endDate) {
        return this.accountRepository.getReport(initialDate, endDate);
    }

    @Override
    public Account getAccount(Long id) {
        return this.accountRepository.getAccount(id);
    }

    @Override
    public Account getAccount(Long id, String accountNumber) {
        return this.accountRepository.getAccount(id, accountNumber);
    }

    @Override
    public Account saveAccount(Account account) {
        ClientModel clientModel = this.clientHttp.getClient(account.getClientId());
        account.setName(clientModel.getName());
        var accountEntity = this.accountMapper.toAccountEntity(account);
        return this.accountRepository.saveAccount(accountEntity);
    }

    @Override
    public void deleteAccount(Long id) {
        this.accountRepository.deleteAccount(id);
    }

    @Override
    public Account updateAccount(long id, Account account) {
        account.setId(id);
        var accountEntity = this.accountMapper.toAccountEntity(account);
        return this.accountRepository.updateAccount(accountEntity);
    }
}
