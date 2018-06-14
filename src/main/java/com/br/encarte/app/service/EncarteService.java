package com.br.encarte.app.service;

import com.br.encarte.app.entity.Encarte;
import com.br.encarte.app.repository.EncarteRepository;
import com.br.encarte.app.service.inter.EncarteServiceAO;
import com.br.encarte.app.specification.EncarteSpecification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
