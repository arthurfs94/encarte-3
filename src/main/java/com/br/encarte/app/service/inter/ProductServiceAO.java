package com.br.encarte.app.service.inter;

import com.br.encarte.app.entity.Product;

import java.util.List;

/**
 * Created by arthur on 20/05/17.
 */

public interface ProductServiceAO {
    void save(Product product);


    void update(Product product);


    List<Product> listAll();


    Product findById(Long id);
}
