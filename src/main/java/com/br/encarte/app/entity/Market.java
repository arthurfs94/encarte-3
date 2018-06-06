package com.br.encarte.app.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Created by arthur on 20/05/17.
 */
@Entity
@Table(name = "MARKET")
public class Market implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "USERNAME", length = 100)
    private String username;

    @Column(name = "PASSWORD", length = 30)
    private String password;
    
    @Column(name = "PICTURE", length = 200)
    private String picture;
    
    @Column(name = "LOJA", length = 20)
    private String loja;
    
    @Column(name = "CNPJ", length = 20)
    private String cnpj;
    
    @OneToMany(mappedBy = "market") 
    @JsonBackReference
    private Collection<Encarte> encartes;
    @Column(name = "LOCALIDADE", length = 40)
    private String localidade;
    
    public Market(Long id, String name, String username, String password, String picture, String loja, String cnpj, String localidade) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.picture = picture;
        this.loja = loja;
        this.cnpj = cnpj;
        this.localidade = localidade;
        
    }

    public Market() {
    	
    }

    public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
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

    public String getUsername() {
        return username;
    }

    public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setUsername(String username) {
        this.username = username;
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoja() {
		return loja;
	}

	public void setLoja(String loja) {
		this.loja = loja;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Collection<Encarte> getEncartes() {
		return encartes;
	}

	public void setEncartes(Collection<Encarte> encartes) {
		this.encartes = encartes;
	}


	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Market)) return false;

        Market market = (Market) o;

        if (id != null ? !id.equals(market.id) : market.id != null) return false;
        if (name != null ? !name.equals(market.name) : market.name != null) return false;
        if (username != null ? !username.equals(market.username) : market.username != null) return false;
        if (picture != null ? !picture.equals(market.picture) : market.picture != null) return false;
        if (loja != null ? !loja.equals(market.loja) : market.loja != null) return false;
        if (cnpj != null ? !cnpj.equals(market.cnpj) : market.cnpj != null) return false;
        if (localidade != null ? !localidade.equals(market.localidade) : market.localidade != null) return false;
        return password != null ? password.equals(market.password) : market.password == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        result = 31 * result + (loja != null ? loja.hashCode() : 0);
        result = 31 * result + (cnpj != null ? cnpj.hashCode() : 0);
        result = 31 * result + (localidade != null ? localidade.hashCode() : 0);
        return result;
    }
}
