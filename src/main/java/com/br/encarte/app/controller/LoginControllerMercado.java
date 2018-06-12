package com.br.encarte.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.encarte.app.entity.Market;
import com.br.encarte.app.repository.MarketRepository;
import com.br.encarte.app.service.MarketService;

@Controller

public class LoginControllerMercado {

	private final MarketRepository marketRepository;

	public LoginControllerMercado(MarketRepository marketRepository) {
		this.marketRepository = marketRepository;
	}

	@RequestMapping(value = "/Mercado", method = RequestMethod.GET)
	public String index() {
		return "inicialMercado";
	}

	@RequestMapping(value = "/SignInMercado", method = RequestMethod.GET)
	public String login() {
		return "SignInMercado";
	}

	// autenticar sistema via sql
	// @RequestMapping("/efetuaLogin"){
	// Client user = realizaLogin Client(
	// "select Client from Market username where password"));
	//
	// if(user=null) "redirect:/SignIn";
	//
	// if(user instanceof Client) {
	// }return "redirect:/ListaProduct";
	//
	// else {
	// return "redirect:/";}
	// }
	//
	// finaliza autenticação do sistema via sql

	// autenticar login se usuario.
//	@RequestMapping("/efetuaLoginMercado")
//	public String efetuaLoginMercado(Market mercado, HttpSession session) {
//		System.out.println("LOGIN MERCADO");
//		System.out.println("USERNAME: "+mercado.getUsername());
//		
//		boolean logado = true;
//		for (Market m : new MarketService(marketRepository).listAll()) {
//			if (m.getUsername().equals(mercado.getUsername()) && m.getPassword().equals(mercado.getPassword())) {
//				logado = true;
//
//			}
//		}
//		if (logado) {
//			session.setAttribute("mercadoLogado", mercado);
//			return "redirect:/inicialMercado";
//		} else {
//			return "redirect:/SignInMercado";
//		}
//	}

	// finaliza autenticação de login por usuario.

	@RequestMapping("logoutMercado")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/SignInMercado";
	}

}
