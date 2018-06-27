package com.br.encarte.app.entity;

import java.io.Serializable;

/**
 * Created by arthur on 20/05/17.
 */
public class MarketRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    
    private String name;

    private String username;

    private String password;
    
    private String picture;
    
    private String loja;
    
    private String cnpj;
    
    private String localidade;
    
    public MarketRequest(Long id, String name, String username, String password, String picture, String loja, String cnpj, String localidade) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.picture = picture;
        this.loja = loja;
        this.cnpj = cnpj;
        this.localidade = localidade;
        
    }

    public MarketRequest() {
    	
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
}
