package com.br.encarte.app.repository;

import com.br.encarte.app.entity.Encarte;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by arthur on 20/05/17.
 */
public interface EncarteRepository extends CrudRepository<Encarte, Long>, JpaSpecificationExecutor<Encarte> {
	
	@Query("Select e from Encarte e where upper(e.name) like %:paramPesquisa% and upper(e.type) like %:filtro% and upper(e.market.localidade)like %:localidade% ")	
	public List<Encarte> findEncarteByParamFiltro(@Param("paramPesquisa") String paramPesquisa,@Param("filtro")String filtro,@Param("localidade")String localidade);
		
		@Query("select e from Encarte e where upper(e.name) like %:paramPesquisa% and e.status = 'Ativado'")	
	public List<Encarte> findAllEncarteParam(@Param("paramPesquisa") String paramPesquisa);



}

