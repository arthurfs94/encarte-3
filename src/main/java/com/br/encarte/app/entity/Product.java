package com.br.encarte.app.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Created by arthur on 20/05/17.
 */
@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne 
    @JoinColumn(name = "idMarket")
    private Market market;
    
    @ManyToOne(targetEntity = Encarte.class)
    @JsonBackReference
    private Encarte encarte;
    
    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "VALUE", length = 100)
    private String value;

    @Column(name = "PICTURE", length = 500)
    private String picture;
    
    @Column(name = "DESCRITION", length = 200)
    private String descrition;
    
    @Column(name = "TYPE", length = 50)
    private String type;
    
    @Column(name = "SERIAL", length = 200)
    private String serial;
    
    public Product(Long id, String name, String value, String picture, String descrition, String type, String serial) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.picture = picture;
        this.descrition = descrition;
        this.type = type;
        this.serial = serial;
    }

    public Product() {
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

	public Market getMarket() {
		return market;
	}

	public void setMarket(Market market) {
		this.market = market;
	}

	public Encarte getEncarte() {
		return encarte;
	}

	public void setEncarte(Encarte encarte) {
		this.encarte = encarte;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (value != null ? !value.equals(product.value) : product.value != null) return false;
        if (descrition != null ? !descrition.equals(product.descrition) : product.descrition != null) return false;
        if (type != null ? !type.equals(product.type) : product.type != null) return false;
        return picture != null ? picture.equals(product.picture) : product.picture == null;
    }

	@Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        result = 31 * result + (descrition != null ? descrition.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
