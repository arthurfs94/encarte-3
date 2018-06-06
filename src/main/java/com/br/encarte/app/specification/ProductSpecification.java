package com.br.encarte.app.specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.br.encarte.app.entity.Product;

public class ProductSpecification implements Specification<Product>{

	public static Specification<Product> nome (String name){
		return (root, criteriaQuery, criteriaBuilder) ->
    		criteriaBuilder.like( criteriaBuilder.lower(root.<String>get("name")), "%" + name.toLowerCase() + "%");
	}
	
	@Override
	public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		return null;
	}
	
}
