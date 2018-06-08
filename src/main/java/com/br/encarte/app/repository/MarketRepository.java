package com.br.encarte.app.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.br.encarte.app.entity.Market;

/**
 * Created by arthur on 20/05/17.
 */
public interface MarketRepository extends CrudRepository<Market, Long>, JpaSpecificationExecutor<Market> {

    Market findByUsername(String name);
}
