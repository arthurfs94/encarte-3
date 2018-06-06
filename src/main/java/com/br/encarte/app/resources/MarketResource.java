package com.br.encarte.app.resources;

import com.br.encarte.app.entity.Market;
import com.br.encarte.app.service.inter.MarketServiceAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by arthur on 20/05/17.
 */
@RestController
@RequestMapping("/encarte/market")
public class MarketResource {

    private final MarketServiceAO marketService;

    @Autowired
    public MarketResource(MarketServiceAO marketService) {
        this.marketService = marketService;

    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final Market save(@RequestBody Market market) {
        this.marketService.save(market);
        return market;
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public final Market update(@RequestBody Market market) {
        this.marketService.save(market);
        return market;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public final String delete(@PathVariable("id") Long id) {
        this.marketService.delete(id);
        return "{}";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public final Market findById(@PathVariable Long id) {
        return this.marketService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public final Iterable<Market> findAll() {
        return this.marketService.listAll();
    }
}
