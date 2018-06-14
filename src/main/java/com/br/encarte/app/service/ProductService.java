package com.br.encarte.app.service;

import com.br.encarte.app.entity.Market;
import com.br.encarte.app.entity.Product;
import com.br.encarte.app.entity.ProductRequest;
import com.br.encarte.app.repository.ProductRepository;
import com.br.encarte.app.service.inter.ProductServiceAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by arthur on 20/05/17.
 */
@Service
public class ProductService implements ProductServiceAO {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Override
	public void save(Product product) {
        this.productRepository.save(product);
    }
    
    @Override
	public void delete(Long id) {
        this.productRepository.delete(id);
    }

    @Override
	public void update(Product product) {
        this.productRepository.save(product);
    }

    @Override
	public List<Product> listAll() {
        return (List<Product>) this.productRepository.findAll();
    }

    @Override
	public Product findById(Long id) {
        return this.productRepository.findOne(id);
    }

	public Product convert(ProductRequest product) {
		Product productNovo = new Product();
		productNovo.setDescrition(product.getDescrition());
		productNovo.setName(product.getName());
		productNovo.setPicture(product.getPicture());
		productNovo.setSerial(product.getSerial());
		productNovo.setType(product.getType());
		productNovo.setValue(product.getType());
		
		Market market = new Market();
		market.setId(product.getIdMarket());
		productNovo.setMarket(market);
		
		return productNovo;
	}
}
