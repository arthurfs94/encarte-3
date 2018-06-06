package com.br.encarte.app.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by arthur on 20/05/17.
 */
@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="client_market", joinColumns=@JoinColumn(name="idClient"), inverseJoinColumns=@JoinColumn(name="idMarket"))		
    private Collection<Market> markets;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "USERNAME", length = 100)
    private String username;

    @Column(name = "PASSWORD", length = 15)
    private String password;
    
    @Column(name = "PICTURE", length = 200)
    private String picture;
    
    @Column(name = "ADM", length = 10)
    private String adm;
    
    public Client(Long id, String name, String username, String password, String picture, String descrition, String adm) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.picture = picture;
        this.adm = adm;
    }

    public Client() {
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

	public String getAdm() {
		return adm;
	}

	public void setAdm(String adm) {
		this.adm = adm;
	}

	public Collection<Market> getMarkets() {
		return markets;
	}

	public void setMarkets(Collection<Market> markets) {
		this.markets = markets;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        if (id != null ? !id.equals(client.id) : client.id != null) return false;
        if (name != null ? !name.equals(client.name) : client.name != null) return false;
        if (username != null ? !username.equals(client.username) : client.username != null) return false;
        if (picture != null ? !picture.equals(client.picture) : client.picture != null) return false;
        if (adm != null ? !adm.equals(client.adm) : client.adm != null) return false;
        return password != null ? password.equals(client.password) : client.password == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        result = 31 * result + (adm != null ? adm.hashCode() : 0);
        return result;
    }
}
