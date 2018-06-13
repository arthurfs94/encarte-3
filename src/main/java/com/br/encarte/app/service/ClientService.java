package com.br.encarte.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.encarte.app.entity.Client;
import com.br.encarte.app.repository.ClientRepository;
import com.br.encarte.app.service.inter.ClientServiceAO;
import com.br.encarte.app.specification.ClientSpecification;

/**
 * Created by arthur on 20/05/17.
 */
@Service
public class ClientService implements ClientServiceAO {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;

    }

    @Override
	public void save(Client client) {
        this.clientRepository.save(client);
    }


    @Override
	public void delete(Long id) {
        this.clientRepository.delete(id);
    }


    @Override
	public void update(Client client) {
        this.clientRepository.save(client);
    }


    @Override
	public List<Client> listAll() {
        return (List<Client>) this.clientRepository.findAll();
    }


    @Override
	public Client findById(Long id) {
        return this.clientRepository.findOne(id);
    }

	public List<Client> findByUsername(String username) {
		return clientRepository.findAll(ClientSpecification.username(username));
	}
}
