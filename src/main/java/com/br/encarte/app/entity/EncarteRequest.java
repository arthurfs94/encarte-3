package com.br.encarte.app.entity;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by arthur on 20/05/17.
 */
public class EncarteRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
    private String name;
    private String description;
    private String data;
    private String picture;
    private String status;
    private String type;
    private Long idMarket;
    private Set<ProductRequest> products;
    
    public EncarteRequest() {
	}

	public EncarteRequest(Long id, String name, String description, String data, String picture, String status,
			String type, long idMarket, Set<ProductRequest> products) {
		super();
		this.id = id;
        this.name = name;
        this.description = description;
        this.data = data;
        this.picture = picture;
        this.status = status;
        this.type = type;
        this.idMarket = idMarket;
        this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getIdMarket() {
		return idMarket;
	}

	public void setIdMarket(Long idMarket) {
		this.idMarket = idMarket;
	}

	public Set<ProductRequest> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductRequest> products) {
		this.products = products;
	}

}