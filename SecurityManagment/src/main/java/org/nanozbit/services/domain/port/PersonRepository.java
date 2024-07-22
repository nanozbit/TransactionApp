package org.nanozbit.services.domain.port;


import org.nanozbit.services.domain.model.Person;
import org.nanozbit.services.infrastructure.adapter.persistence.entity.PersonEntity;

import java.util.Optional;

public interface PersonRepository {
    Iterable<Person> getPersons();

    Optional<Person> getPerson(String id);

    PersonEntity savePerson(Person person);

    void DeletePerson(String id);

    Person UpdatePerson(long id, Person person);
}
