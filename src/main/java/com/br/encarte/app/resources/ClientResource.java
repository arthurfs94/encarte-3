package com.br.encarte.app.resources;

import com.br.encarte.app.entity.Client;
import com.br.encarte.app.service.inter.ClientServiceAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by arthur on 20/05/17.
 */
@RestController
@RequestMapping("/encarte/client")
public class ClientResource {

    private final ClientServiceAO clientService;

    @Autowired
    public ClientResource(ClientServiceAO clientService) {
        this.clientService = clientService;

    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final Client save(@RequestBody Client client) {
        this.clientService.save(client);
        return client;
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final Client update(@RequestBody Client client) {
        this.clientService.save(client);
        return client;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public final String delete(@PathVariable("id") Long id) {
        this.clientService.delete(id);
        return "{}";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public final Client findById(@PathVariable Long id) {
        return this.clientService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public final Iterable<Client> findAll() {
        return this.clientService.listAll();
    }
    
}
