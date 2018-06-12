package com.br.encarte.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests()
			.antMatchers("/Principal").permitAll()
			.antMatchers("/product/").permitAll()
			.antMatchers("/product/**").permitAll()
			.antMatchers("/encarte/").permitAll()
			.antMatchers("/encarte/**").permitAll()
			.antMatchers("/product/").permitAll()
			.antMatchers("/product/**").permitAll()
			.antMatchers("/market/").permitAll()
			.antMatchers("/market/**").permitAll()
			.antMatchers("/static/js/functions.js").permitAll()
			.antMatchers("/static/js/Principal.js").permitAll()
			.antMatchers(HttpMethod.POST, "/login").permitAll()
			.antMatchers(HttpMethod.POST, "/SignInMercado").permitAll()
			.antMatchers(HttpMethod.GET, "/SignInMercado").permitAll()
			.anyRequest().authenticated()
			.and()
			
			// filtra requisições de login
			.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
	                UsernamePasswordAuthenticationFilter.class)
			
			.addFilterBefore(new JWTLoginFilter("/efetuaLoginMercado", authenticationManager()),
					UsernamePasswordAuthenticationFilter.class)
			
			// filtra outras requisições para verificar a presença do JWT no header
			.addFilterBefore(new JWTAuthenticationFilter(),
	                UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("admin")
			.password("admin")
			.roles("ADMIN");
		
//		auth.userDetailsService(userDetailsService)
	
	}
}