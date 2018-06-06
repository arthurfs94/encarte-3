package com.br.encarte.app.repository;

import com.br.encarte.app.entity.Market;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by arthur on 20/05/17.
 */
public interface MarketRepository extends CrudRepository<Market, Long> {

    Market findByUsername(String name);
}
