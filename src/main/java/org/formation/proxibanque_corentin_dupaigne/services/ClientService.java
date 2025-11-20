package org.formation.proxibanque_corentin_dupaigne.services;

import org.formation.proxibanque_corentin_dupaigne.models.Client;
import org.formation.proxibanque_corentin_dupaigne.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
