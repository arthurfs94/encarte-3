package com.br.encarte.app.service.inter;

import com.br.encarte.app.entity.Client;


import java.util.List;


/**
 * Created by arthur on 20/05/17.
 */
	  
	public interface ClientServiceAO {


    void save(Client client);


    void delete(Long id);


    void update(Client client);


    List<Client> listAll();


    Client findById(Long id);
    
}