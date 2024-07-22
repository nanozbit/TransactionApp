package org.nanozbit.services.infrastructure.adapter.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.nanozbit.services.domain.model.Transaction;
import org.nanozbit.services.infrastructure.adapter.repository.entity.TransactionEntity;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "transactionDate", target = "transactionDate"),
            @Mapping(source = "transactionType", target = "transactionType"),
            @Mapping(source = "value", target = "value"),
            @Mapping(source = "sales", target = "sales"),
            @Mapping(source = "account", target = "account")
    })
    Transaction toTransaction(TransactionEntity transaction);
    Iterable<Transaction> toTransactions(Iterable<TransactionEntity> transactionEntities);

    @InheritInverseConfiguration
    TransactionEntity toTransactionEntity(Transaction account);

}
