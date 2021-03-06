package com.br.encarte.app.specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.br.encarte.app.entity.Market;

public class MarketSpecification implements Specification<Market>{

	public static Specification<Market> name (String name){
		return (root, criteriaQuery, criteriaBuilder) ->
    		criteriaBuilder.like( criteriaBuilder.lower(root.<String>get("name")), "%" + name.toLowerCase() + "%");
	}
	
	public static Specification<Market> username (String username){
		return (root, criteriaQuery, criteriaBuilder) ->
		criteriaBuilder.like( root.<String>get("username"), username);
	}
	
	@Override
	public Predicate toPredicate(Root<Market> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		return null;
	}
	
}
