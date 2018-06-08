package com.br.encarte.app.specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.br.encarte.app.entity.Market;
import com.br.encarte.app.entity.Product;

public class ProductSpecification implements Specification<Product>{

	public static Specification<Product> name (String name){
		return (root, criteriaQuery, criteriaBuilder) ->
    		criteriaBuilder.like( criteriaBuilder.lower(root.<String>get("name")), "%" + name.toLowerCase() + "%");
	}
	
	public static Specification<Product> id (Long id){
		return (root, criteriaQuery, criteriaBuilder) ->
		criteriaBuilder.equal( root.<String>get("id"), id);
	}
	
	public static Specification<Product> marketId (Long id){
		return new Specification<Product>() {
	        public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
	            Join<Product, Market> prodMarket = root.join("market");
	            return cb.equal(prodMarket.get("id"), id);
	        }
	    };
	}
			
	
	@Override
	public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		return null;
	}
	
}
