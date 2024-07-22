package org.nanozbit.services.infrastructure.adapter.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.nanozbit.services.domain.model.Client;
import org.nanozbit.services.infrastructure.adapter.persistence.entity.ClientEntity;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "address", source = "address"),
            @Mapping(target = "gender", source = "gender"),
            @Mapping(target = "age", source = "age"),
            @Mapping(target = "identityDocument", source = "identityDocument"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "status", target = "status")
    })
    Client toClient(ClientEntity client);


    Iterable<Client> toClients(Iterable<ClientEntity> clientEntities);

    @InheritInverseConfiguration
    ClientEntity toClientEntity(Client client);

}
