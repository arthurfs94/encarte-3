package com.br.encarte.app.entity;

import java.util.ArrayList;
import java.util.List;

public class ResultadoPesquisa {

	private List<Encarte>encartes = new ArrayList<Encarte>();
	private List<Product> produtos = new ArrayList<Product>();
	public List<Encarte> getEncartes() {
		return encartes;
	}
	public void setEncartes(List<Encarte> encartes) {
		this.encartes = encartes;
	}
	public List<Product> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Product> produtos) {
		this.produtos = produtos;
	}
	
}
