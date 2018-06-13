package com.br.encarte.app.specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.br.encarte.app.entity.Client;
import com.br.encarte.app.entity.Market;

public class ClientSpecification implements Specification<Market>{

	public static Specification<Client> username (String username){
		return (root, criteriaQuery, criteriaBuilder) ->
		criteriaBuilder.like( root.<String>get("username"), username);
	}
	
	@Override
	public Predicate toPredicate(Root<Market> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		return null;
	}
	
}
