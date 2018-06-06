package com.br.encarte.app.service.inter;

import com.br.encarte.app.entity.Market;


import java.util.List;


/**
 * Created by arthur on 20/05/17.
 */
	  
	public interface MarketServiceAO {


    void save(Market market);


    void delete(Long id);


    void update(Market market);


    List<Market> listAll();


    Market findById(Long id);
    
}