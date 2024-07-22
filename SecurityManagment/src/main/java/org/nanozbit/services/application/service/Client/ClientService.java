package org.nanozbit.services.application.service.Client;

import org.nanozbit.services.infrastructure.adapter.rest.modelView.ClientModelView;

public interface ClientService {
    Iterable<ClientModelView> getClients();

    ClientModelView getClient(Long id);

    ClientModelView saveClient(ClientModelView client);

    void deleteClient(Long id);

    ClientModelView updateClient(long id, ClientModelView client);
}
