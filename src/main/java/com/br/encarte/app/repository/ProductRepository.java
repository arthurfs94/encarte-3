package com.br.encarte.app.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.br.encarte.app.entity.Product;

/**
 * Created by arthur on 20/05/17.
 */
public interface ProductRepository extends CrudRepository<Product, Long>, JpaSpecificationExecutor<Product> {
	
	@Query("Select p from Product p where lower(p.name) like lower(:name)")
	List<Product> findAllByName(@Param("name")String name);
	public List<Product> findByName(String name);

	@Query("Select p from Product p where upper(p.name) like %:paramPesquisa% and upper(p.type) like %:filtro%")	
	public List<Product> findProductByParamFiltro(@Param("paramPesquisa") String paramPesquisa,@Param("filtro")String filtro);


}
