package com.br.encarte.app.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Created by arthur on 20/05/17.
 */
@Entity
@Table(name = "ENCARTE")
public class Encarte implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idMarket")
    @JsonManagedReference
    private Market market;
    
    @ManyToMany
    @JoinTable(name="product_encarte", joinColumns=@JoinColumn(name="idEncarte"), inverseJoinColumns=@JoinColumn(name="idProduct"))		
    @JsonManagedReference
    private Collection<Product> product;
    
    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "DESCRIPTION", length = 200)
    private String description;

    @Column(name = "DATA", length = 10)
    private String data;
    
    @Column(name = "PICTURE", length = 200)
    private String picture;
    
    @Column(name = "STATUS", length = 10)
    private String status;
    
    @Column(name = "TYPE", length = 20)
    private String type;
    
    public Encarte
    (Long id, String name, String description, String data, String picture, String status, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.data = data;
        this.picture = picture;
        this.status = status;
        this.type = type;
    }

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Encarte() {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Market getMarket() {
		return market;
	}

	public void setMarket(Market market) {
		this.market = market;
	}

	public Collection<Product> getProduct() {
		return product;
	}

	public void setProduct(Collection<Product> product) {
		this.product = product;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Encarte)) return false;

        Encarte encarte = (Encarte) o;

        if (id != null ? !id.equals(encarte.id) : encarte.id != null) return false;
        if (name != null ? !name.equals(encarte.name) : encarte.name != null) return false;
        if (description != null ? !description.equals(encarte.description) : encarte.description != null) return false;
        if (picture != null ? !picture.equals(encarte.picture) : encarte.picture != null) return false;
        if (status != null ? !status.equals(encarte.status) : encarte.status != null) return false;
        if (type != null ? !type.equals(encarte.type) : encarte.type != null) return false;
        return data != null ? data.equals(encarte.data) : encarte.data == null;
         
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
