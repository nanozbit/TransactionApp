package org.nanozbit.services.application.service.Person;

import org.nanozbit.services.domain.model.Person;

import java.util.Optional;

public interface PersonService {
    Iterable<Person> getPersons();

    Optional<Person> getPerson(String id);

    Person savePerson(Person person);

    void DeletePerson(String id);

    Person UpdatePerson(long id, Person person);
}
