package com.br.encarte.app.service.inter;

import com.br.encarte.app.entity.Encarte;


import java.util.List;


/**
 * Created by arthur on 20/05/17.
 */
	  
	public interface EncarteServiceAO {


    void save(Encarte encarte);



    void delete(Long id);


    void update(Encarte encarte);


    List<Encarte> listAll();


    Encarte findById(Long id);


	List<Encarte> findEncarteByMarketId(Long id);
    
}