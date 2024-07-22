package org.nanozbit.services.infrastructure.adapter.rest.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.nanozbit.services.domain.model.Client;
import org.nanozbit.services.domain.model.Person;
import org.nanozbit.services.infrastructure.adapter.rest.modelView.ClientModelView;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ClientRequestMapper {


    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "address", source = "address"),
            @Mapping(target = "gender", source = "gender"),
            @Mapping(target = "age", source = "age"),
            @Mapping(target = "identityDocument", source = "identityDocument"),
            @Mapping(target = "password", source = "password"),
            @Mapping(target = "status", source = "status")
    })
    ClientModelView toClientViewModel(Client client);
//
//    ClientModelView toOptionalClientViewModel(Client client);

    Iterable<ClientModelView> toClientViewModels(Iterable<Client> clients);

    @InheritInverseConfiguration
    Client toClient(ClientModelView clientView);

    @InheritInverseConfiguration
    Person toPerson(ClientModelView clientView);

}
