package com.br.encarte.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.br.encarte.app.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests()
			.antMatchers(HttpMethod.GET,"/productregistration").permitAll()
			.antMatchers(HttpMethod.GET,"/ListaProdutosUsuarios").permitAll()
			.antMatchers(HttpMethod.GET,"/vincularProdutos").permitAll()
			.antMatchers(HttpMethod.GET,"/Principal").permitAll()
			.antMatchers(HttpMethod.GET,"/product/").permitAll()
			.antMatchers(HttpMethod.GET,"/product/**").permitAll()
			.antMatchers(HttpMethod.GET,"/encarte/").permitAll()
			.antMatchers(HttpMethod.GET,"/encarte/**").permitAll()
			.antMatchers(HttpMethod.GET,"/product/").permitAll()
			.antMatchers(HttpMethod.GET,"/product/**").permitAll()
			.antMatchers(HttpMethod.GET,"/market/").permitAll()
			.antMatchers(HttpMethod.GET,"/market/**").permitAll()
			.antMatchers(HttpMethod.GET,"/static/**").permitAll()
			.antMatchers(HttpMethod.GET,"/templates/**").permitAll()
			.antMatchers(HttpMethod.GET,"/favicon.ico").permitAll()
			.antMatchers(HttpMethod.GET,"/paginamercado").permitAll()
			.antMatchers(HttpMethod.GET,"/paginamercado/**").permitAll()
			.antMatchers(HttpMethod.GET,"/mercado").permitAll()
			.antMatchers(HttpMethod.GET,"/gerenciamentoproduto").permitAll()
			.antMatchers(HttpMethod.GET,"/gerenciamentoencartes").permitAll()
			.antMatchers(HttpMethod.GET,"/listaprodutos").permitAll()
			.antMatchers(HttpMethod.GET,"/listaencartes").permitAll()
			.antMatchers(HttpMethod.GET,"/productregistration").permitAll()
			.antMatchers(HttpMethod.POST, "/login").permitAll()
			.antMatchers(HttpMethod.POST, "/signinmercado").permitAll()
			.antMatchers(HttpMethod.GET, "/signinmercado").permitAll()
			.anyRequest().authenticated()
			.and()
			
			// filtra requisições de login
			.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
	                UsernamePasswordAuthenticationFilter.class)
			
		
			// filtra outras requisições para verificar a presença do JWT no header
			.addFilterBefore(new JWTAuthenticationFilter(),
	                UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder);
	}
	
}