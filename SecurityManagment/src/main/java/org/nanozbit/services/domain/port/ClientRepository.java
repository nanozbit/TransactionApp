package org.nanozbit.services.domain.port;


import org.nanozbit.services.domain.model.Client;
import org.nanozbit.services.infrastructure.adapter.persistence.entity.ClientEntity;

public interface ClientRepository {
    Iterable<ClientEntity> getClients();

    ClientEntity getClient(Long id);

    ClientEntity saveClient(Client client);

    void deleteClient(Long id);

    ClientEntity updateClient(Client client);
}
