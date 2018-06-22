package com.br.encarte.app.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import com.br.encarte.app.entity.Encarte;
import com.br.encarte.app.entity.EncarteRequest;
import com.br.encarte.app.entity.Market;
import com.br.encarte.app.entity.Product;
import com.br.encarte.app.entity.ProductRequest;
import com.br.encarte.app.repository.EncarteRepository;
import com.br.encarte.app.service.inter.EncarteServiceAO;
import com.br.encarte.app.specification.EncarteSpecification;

/**
 * Created by arthur on 20/05/17.
 */
@Service
public class EncarteService implements EncarteServiceAO {

    private final EncarteRepository encarteRepository;

    @Autowired
    public EncarteService(EncarteRepository encarteRepository) {
        this.encarteRepository = encarteRepository;

    }

    @Override
	public void save(Encarte encarte) {
        this.encarteRepository.save(encarte);
    }


    @Override
	public void delete(Long id) {
        this.encarteRepository.delete(id);
    }


    @Override
	public void update(Encarte encarte) {
        this.encarteRepository.save(encarte);
    }


    @Override
	public List<Encarte> listAll() {
        return (List<Encarte>) this.encarteRepository.findAll();
    }


    @Override
	public Encarte findById(Long id) {
        return this.encarteRepository.findOne(id);
    }
    
    @Override
	public List<Encarte> findEncarteByMarketId(Long id) {
    	Specifications<Encarte> where = Specifications.where(EncarteSpecification.marketId(id));
    	return encarteRepository.findAll(where);
    }
    
    public Encarte convert(EncarteRequest encarte) {
		Encarte encarteNovo = new Encarte();
		encarteNovo.setId(encarte.getId());
		encarteNovo.setDescription(encarte.getDescription());
		encarteNovo.setName(encarte.getName());
		encarteNovo.setPicture(encarte.getPicture());
		encarteNovo.setStatus(encarte.getStatus());
		encarteNovo.setType(encarte.getType());
		encarteNovo.setData(encarte.getData());
		
		Market market = new Market();
		market.setId(encarte.getIdMarket());
		encarteNovo.setMarket(market);
		
		return encarteNovo;
	}

	public Encarte save(EncarteRequest encarteRequest) {
		Encarte encarte = encarteRepository.findOne(encarteRequest.getId());
		
		Set<Product> products = new HashSet<>();
		
		for (ProductRequest productRequest : encarteRequest.getProducts()) {
			Product product = new Product();
			product.setId(productRequest.getId());
			products.add(product);
		}
		
		encarte.setProduct(products);
		
		return encarteRepository.save(encarte);
	}
}
