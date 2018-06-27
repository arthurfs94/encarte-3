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
    	
    	UserDetails userDetails;
    	if(market != null) {
    		GrantedAuthority authority = new SimpleGrantedAuthority("market");
    		
    		userDetails = (UserDetails)new User(market.getUsername(),
    				market.getPassword(), Arrays.asList(authority));
    	}else {
    		if("admin".equals(usernameOrEmail)) {
    			GrantedAuthority authority = new SimpleGrantedAuthority("admin");
    			
    			userDetails = (UserDetails)new User(
    						usernameOrEmail,
    						"$2a$04$mWJQfIE1rfIcAUgCvC6aPOsLDbka8GVGc/7n/Zkk087Ki1ABcH30S", 
    						Arrays.asList(authority)
    			);
    			
    		}else {
    			//error
    			GrantedAuthority authority = new SimpleGrantedAuthority("");
    			userDetails = (UserDetails)new User(null,
    					null, Arrays.asList(authority));
    			
    		}
    	}
        
		
		return userDetails;

    }

}