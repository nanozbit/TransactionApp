package org.nanozbit.services.application.service.Person;

import org.nanozbit.services.domain.model.Person;
import org.nanozbit.services.domain.port.PersonRepository;
import org.nanozbit.services.infrastructure.adapter.persistence.mapper.PersonMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DomainPersonService implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public DomainPersonService(PersonRepository personRepository,
                               PersonMapper personMapper) {
        this.personRepository = personRepository;
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
    public Person savePerson(Person person) {
        var personEntity = this.personRepository.savePerson(person);
        return this.personMapper.toPerson(personEntity);
    }

    @Override
    public void DeletePerson(String id) {

    }

    @Override
    public Person UpdatePerson(long id, Person person) {
        return null;
    }
}
