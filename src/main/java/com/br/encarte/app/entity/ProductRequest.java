package com.br.encarte.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Created by arthur on 20/05/17.
 */
public class ProductRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
    private String name;
    private Long idMarket;
    private Long idEncarte;
    private String value;
    private String picture;
    private String descrition;
    private String type;
    private String serial;
    
    public ProductRequest() {
	}

	public ProductRequest(Long id, String name, Long idMarket, Long idEncarte, String value, String picture,
			String descrition, String type, String serial) {
		super();
		this.id = id;
		this.name = name;
		this.idMarket = idMarket;
		this.idEncarte = idEncarte;
		this.value = value;
		this.picture = picture;
		this.descrition = descrition;
		this.type = type;
		this.serial = serial;
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

	public Long getIdMarket() {
		return idMarket;
	}

	public void setIdMarket(Long idMarket) {
		this.idMarket = idMarket;
	}

	public Long getIdEncarte() {
		return idEncarte;
	}

	public void setIdEncarte(Long idEncarte) {
		this.idEncarte = idEncarte;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescrition() {
		return descrition;
	}

	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

}
