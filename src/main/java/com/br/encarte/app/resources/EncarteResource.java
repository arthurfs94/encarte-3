package com.br.encarte.app.resources;

import com.br.encarte.app.entity.Encarte;
import com.br.encarte.app.service.inter.EncarteServiceAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by arthur on 20/05/17.
 */
@RestController
@RequestMapping("/encarte/encarte")
public class EncarteResource {

    private final EncarteServiceAO encarteService;

    @Autowired
    public EncarteResource(EncarteServiceAO encarteService) {
        this.encarteService = encarteService;

    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final Encarte save(@RequestBody Encarte encarte) {
        this.encarteService.save(encarte);
        return encarte;
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final Encarte update(@RequestBody Encarte encarte) {
    	System.out.println(encarte.getId());
        this.encarteService.save(encarte);
        return encarte;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public final String delete(@PathVariable("id") Long id) {
        this.encarteService.delete(id);
        return "{}";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public final Encarte findById(@PathVariable Long id) {
        return this.encarteService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public final Iterable<Encarte> findAll() {
        return this.encarteService.listAll();
    }
}
