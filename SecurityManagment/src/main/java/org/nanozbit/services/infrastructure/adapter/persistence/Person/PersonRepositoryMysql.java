package org.nanozbit.services.infrastructure.adapter.persistence.Person;

import lombok.extern.slf4j.Slf4j;
import org.nanozbit.services.domain.model.Person;
import org.nanozbit.services.domain.port.PersonRepository;
import org.nanozbit.services.infrastructure.adapter.persistence.entity.PersonEntity;
import org.nanozbit.services.infrastructure.adapter.persistence.mapper.PersonMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Slf4j
public class PersonRepositoryMysql implements PersonRepository {
    private final PersonJpaRepository personJpaRepository;
    private final PersonMapper personMapper;

    public PersonRepositoryMysql(PersonJpaRepository personJpaRepository,
                                 PersonMapper personMapper) {
        this.personJpaRepository = personJpaRepository;
        this.personMapper = personMapper;
    }

    @Override
    public Iterable<Person> getPersons() {
        return null;
    }

    @Override
    public Optional<Person> getPerson(String id) {
        return Optional.empty();
    }

    @Override
    public PersonEntity savePerson(Person person) {
        var personEntity = personMapper.toPersonEntity(person);
        return this.personJpaRepository.save(personEntity);
    }

    @Override
    public void DeletePerson(String id) {

    }

    @Override
    public Person UpdatePerson(long id, Person person) {
        return null;
    }
}
