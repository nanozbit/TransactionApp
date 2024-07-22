package org.nanozbit.services.infrastructure.adapter.persistence.Person;


import org.nanozbit.services.infrastructure.adapter.persistence.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJpaRepository extends JpaRepository<PersonEntity, Long> {
}
