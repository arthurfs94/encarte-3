package com.br.encarte.app.service;

import com.br.encarte.app.entity.Market;
import com.br.encarte.app.repository.MarketRepository;
import com.br.encarte.app.service.inter.MarketServiceAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by arthur on 20/05/17.
 */
@Service
public class MarketService implements MarketServiceAO {

    private final MarketRepository marketRepository;

    @Autowired
    public MarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;

    }

    @Override
	public void save(Market market) {
        this.marketRepository.save(market);
    }


    @Override
	public void delete(Long id) {
        this.marketRepository.delete(id);
    }


    @Override
	public void update(Market market) {
        this.marketRepository.save(market);
    }


    @Override
	public List<Market> listAll() {
        return (List<Market>) this.marketRepository.findAll();
    }


    @Override
	public Market findById(Long id) {
        return this.marketRepository.findOne(id);
    }
}
