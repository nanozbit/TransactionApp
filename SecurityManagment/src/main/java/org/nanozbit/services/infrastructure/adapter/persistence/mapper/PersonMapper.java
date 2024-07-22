package org.nanozbit.services.infrastructure.adapter.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.nanozbit.services.domain.model.Person;
import org.nanozbit.services.infrastructure.adapter.persistence.entity.PersonEntity;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "address", source = "address"),
            @Mapping(target = "gender", source = "gender"),
            @Mapping(target = "age", source = "age"),
            @Mapping(target = "identityDocument", source = "identityDocument"),
    })
    Person toPerson(PersonEntity person);

    Iterable<Person> toPersons(Iterable<PersonEntity> personEntities);

    @InheritInverseConfiguration
    PersonEntity toPersonEntity(Person person);
}
