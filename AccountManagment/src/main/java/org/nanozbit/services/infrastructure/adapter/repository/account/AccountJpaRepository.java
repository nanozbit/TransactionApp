package org.nanozbit.services.infrastructure.adapter.repository.account;


import org.nanozbit.services.infrastructure.adapter.repository.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountJpaRepository extends JpaRepository<AccountEntity, Long> {

    List<AccountEntity> findByClientIdAndAccountNumber(Long id, String accountNumber);
}
