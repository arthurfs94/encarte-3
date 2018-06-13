package com.br.encarte.app.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.br.encarte.app.entity.Market;
import com.br.encarte.app.repository.MarketRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private MarketRepository marketRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {

    	Market market = marketRepository.findByUsername(usernameOrEmail);
        

    	GrantedAuthority authority = new SimpleGrantedAuthority("admin");
		UserDetails userDetails = (UserDetails)new User(market.getUsername(),
				market.getPassword(), Arrays.asList(authority));

		return userDetails;

    }

}