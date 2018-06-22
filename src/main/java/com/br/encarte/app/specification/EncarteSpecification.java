package com.br.encarte.app.specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.br.encarte.app.entity.Encarte;
import com.br.encarte.app.entity.Market;

public class EncarteSpecification implements Specification<Encarte>{

	public static Specification<Encarte> id (Long id){
		return (root, criteriaQuery, criteriaBuilder) ->
		criteriaBuilder.equal( root.<String>get("id"), id);
	}
	
	public static Specification<Encarte> name (String name){
		return (root, criteriaQuery, criteriaBuilder) ->
    		criteriaBuilder.like( criteriaBuilder.lower(root.<String>get("name")), "%" + name.toLowerCase() + "%");
	}
	
	public static Specification<Encarte> marketId (Long id){
		return new Specification<Encarte>() {
	        public Predicate toPredicate(Root<Encarte> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
	            Join<Encarte, Market> prodMarket = root.join("market");
	            return cb.equal(prodMarket.get("id"), id);
	        }
	    };
	}
	
	@Override
	public Predicate toPredicate(Root<Encarte> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		return null;
	}
	
}
