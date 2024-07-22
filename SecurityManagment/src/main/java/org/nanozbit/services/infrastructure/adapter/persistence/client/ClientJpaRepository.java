package org.nanozbit.services.infrastructure.adapter.persistence.client;


import org.nanozbit.services.infrastructure.adapter.persistence.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ClientJpaRepository extends JpaRepository<ClientEntity, Long> {
}
