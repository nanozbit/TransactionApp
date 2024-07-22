package org.nanozbit.services.infrastructure.adapter.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.nanozbit.services.domain.model.Account;
import org.nanozbit.services.infrastructure.adapter.repository.entity.AccountEntity;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "accountNumber", target = "accountNumber"),
            @Mapping(source = "accountType", target = "accountType"),
            @Mapping(source = "initialBalance", target = "initialBalance"),
            @Mapping(source = "lastBalance", target = "lastBalance"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "transactions", target = "transactions")
    })
    Account toAccount(AccountEntity account);

    Iterable<Account> toAccounts(Iterable<AccountEntity> accountEntities);

    @InheritInverseConfiguration
    AccountEntity toAccountEntity(Account account);

}
