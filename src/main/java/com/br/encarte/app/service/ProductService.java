package com.br.encarte.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import com.br.encarte.app.entity.Market;
import com.br.encarte.app.entity.Product;
import com.br.encarte.app.entity.ProductRequest;
import com.br.encarte.app.repository.ProductRepository;
import com.br.encarte.app.service.inter.ProductServiceAO;
import com.br.encarte.app.specification.ProductSpecification;

import jersey.repackaged.com.google.common.collect.ImmutableList;

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
		productNovo.setValue(product.getValue());
		
		Market market = new Market();
		market.setId(product.getIdMarket());
		productNovo.setMarket(market);
		
		return productNovo;
	}

	public Object montarListaProdutosEncarte(Long idMarket, Long idEncarte) {
			
		Specifications<Product> whereProductsEncarte = Specifications.where(ProductSpecification.encarteId(idEncarte));
    	List<Product> productsEncarte = productRepository.findAll(whereProductsEncarte);
    	
    	Specifications<Product> where = Specifications.where(ProductSpecification.marketId(idMarket));
    	List<Product> products = productRepository.findAll(where) ;
    	
		
		String  str = "";
		
		for (int i = 0; i < products.size(); i++) {

			str += "<div class='row'>";
			
			str += "<div class='col-4'><strong>Nome do Produto: </strong>" + products.get(i).getName() + "</div>";
			str += "<div class='col-4'><strong>Valor: </strong>" + products.get(i).getValue() + "</div>";
			str += "<div class='col-4'>";
			
			str += "<input type='checkbox' name='productBound' value='" + products.get(i).getId() + "' ";
			if(productsEncarte.contains(products.get(i))) {
				str += "checked";
			}
			str += ">";
			
			str += "</div>";
			
			str += "</div>";

		}
		
		return str;
	}

	public Object montarListaEncarteProduto(Long idMarket, Long idEncarte) {
    	
		Specifications<Product> where = Specifications.where(ProductSpecification.encarteId(idEncarte));
    	List<Product> productsEncarte = productRepository.findAll(where);
		
		String  str = "";
		
		for (int i = 0; i < productsEncarte.size(); i++) {

			if (i % 3 == 0) {
				str += "<div class='row'>";
			}
			str += "<div class='col-sm-4'>";

			str += "<dl>";
			str += "</dd>";
			
			str += "<img class='card-img-top' src='" + productsEncarte.get(i).getPicture()
					+ "' alt='Card image' style='width:60%'>";

			str += "<dl>";
			str += "</dd>";
			
			str += "<strong>Nome do Produto: </strong>" + productsEncarte.get(i).getName();
			str += "<dl>";
			str += "</dd>";
			
			str += "<strong>Valor do produto: </strong>" + productsEncarte.get(i).getValue();
			str += "<dl>";
			str += "</dd>";
			
			str += "<strong>Id do Encarte: </strong> " + productsEncarte.get(i).getId();
			str += "<dl>";
			str += "</dd>";
			
			str += "<strong>Categoria: </strong> " + productsEncarte.get(i).getType();
			
			str += "<dl>";
			str += "</dd>";

			str += "<dl>";
			str += "</dl>";

			str += "</div>";

			if (i % 3 == 2) {
				str += "</div>";
			}

		}
		
		return str;
	}
}
