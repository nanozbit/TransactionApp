package org.nanozbit.services.infrastructure.adapter.persistence.client;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.nanozbit.services.domain.model.Client;
import org.nanozbit.services.domain.port.ClientRepository;
import org.nanozbit.services.infrastructure.adapter.persistence.entity.ClientEntity;
import org.nanozbit.services.infrastructure.adapter.persistence.exceptions.ClientException;
import org.nanozbit.services.infrastructure.adapter.persistence.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

@Repository
@Transactional
@Slf4j
public class ClientRepositoryMysql implements ClientRepository {

    private final ClientJpaRepository clientJpaRepository;

    private final ClientMapper clientMapper;

    @Autowired
    public ClientRepositoryMysql(ClientJpaRepository clientJpaRepository, final ClientMapper clientMapper) {
        this.clientJpaRepository = clientJpaRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public Iterable<ClientEntity> getClients() {
        return this.clientJpaRepository.findAll();
    }

    @Override
    public ClientEntity getClient(Long id) {
        try {
            return this.clientJpaRepository.findById(id).orElseThrow();
        } catch (NoSuchElementException e) {
            throw new ClientException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public ClientEntity saveClient(Client client) {
        var clientEntity = this.clientMapper.toClientEntity(client);
        return this.clientJpaRepository.save(clientEntity);
    }

    @Override
    public void deleteClient(Long id) {
        this.clientJpaRepository.deleteById(id);
    }

    @Override
    public ClientEntity updateClient(Client client) {
        var clientEntity = this.clientMapper.toClientEntity(client);
        return this.clientJpaRepository.save(clientEntity);
    }
}
