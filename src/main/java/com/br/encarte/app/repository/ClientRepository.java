package com.br.encarte.app.repository;

import com.br.encarte.app.entity.Client;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by arthur on 20/05/17.
 */
public interface ClientRepository extends CrudRepository<Client, Long> {

    Client findByUsername(String name);
}
