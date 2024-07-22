package org.nanozbit.services.application.service.Client;

import org.nanozbit.services.domain.port.ClientRepository;
import org.nanozbit.services.infrastructure.adapter.persistence.mapper.ClientMapper;
import org.nanozbit.services.infrastructure.adapter.rest.mapper.ClientRequestMapper;
import org.nanozbit.services.infrastructure.adapter.rest.modelView.ClientModelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainClientService implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientRequestMapper clientRequestMapper;
    private final ClientMapper clientMapper;

    @Autowired
    public DomainClientService(ClientRepository clientRepository,
                               ClientRequestMapper clientRequestMapper,
                               ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientRequestMapper = clientRequestMapper;
        this.clientMapper = clientMapper;
    }

    @Override
    public Iterable<ClientModelView> getClients() {
        var clients = this.clientMapper.toClients(this.clientRepository.getClients());
        return this.clientRequestMapper.toClientViewModels(clients);
    }

    @Override
    public ClientModelView getClient(Long id) {
        var clientModel = this.clientMapper.toClient(this.clientRepository.getClient(id));

        return this.clientRequestMapper.toClientViewModel(clientModel);
    }

    @Override
    public ClientModelView saveClient(ClientModelView clientViewModel) {
        var clientRequest = this.clientRequestMapper.toClient(clientViewModel);
        var clientResponse = this.clientMapper.toClient(this.clientRepository.saveClient(clientRequest));
        return this.clientRequestMapper.toClientViewModel(clientResponse);
    }

    @Override
    public void deleteClient(Long id) {
        this.clientRepository.deleteClient(id);

    }

    @Override
    public ClientModelView updateClient(long id, ClientModelView client) {
        var clientRequest = this.clientRequestMapper.toClient(client);
        clientRequest.setId(id);
        var clientResponse = this.clientMapper.toClient(this.clientRepository.updateClient(clientRequest));
        return this.clientRequestMapper.toClientViewModel(clientResponse);
    }
}
