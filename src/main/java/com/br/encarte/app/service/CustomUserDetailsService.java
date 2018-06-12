package com.br.encarte.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.encarte.app.entity.Client;
import com.br.encarte.app.repository.ClientRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        Client user = clientRepository.findByUsername(usernameOrEmail);
        
//        UserDetails details = {};
                

//        return UserDetails.  .create(user);
        return null;
    }

    // This method is used by JWTAuthenticationFilter
    @Transactional
    public UserDetails loadUserById(Long id) {
        Client user = clientRepository.findOne(id);

//        return new UserDetails(){};
        return null;
    }
}