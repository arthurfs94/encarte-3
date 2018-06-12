package com.br.encarte.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.encarte.app.entity.Client;
import com.br.encarte.app.repository.ClientRepository;
import com.br.encarte.app.repository.MarketRepository;
import com.br.encarte.app.service.ClientService;

@Controller
public class LoginController {

	private final ClientRepository clientRepository;
	private MarketRepository marketRepository;

	public LoginController(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
		this.marketRepository = marketRepository;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "inicial";
	}

	@RequestMapping(value = "/SignIn", method = RequestMethod.GET)
	public String login() {
		return "SignIn";
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

	// autenticar login se usario.
	@RequestMapping("/efetuaLogin")
	public String efetuaLogin(Client usuario, HttpSession session) {
		System.out.println("EFETUAR LOGIN");
		for (Client c : new ClientService(clientRepository).listAll()) {
			if (c.getUsername().equals(usuario.getUsername()) && c.getPassword().equals(usuario.getPassword())) {
				session.setAttribute("usuarioLogado", usuario);
				return "redirect:/";
			}
		}
		return "redirect:/SignIn";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/SignIn";
	}

	// finaliza autenticação de login por usuario.

	
}
