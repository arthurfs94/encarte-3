package com.br.encarte.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.br.encarte.app.entity.Market;
import com.br.encarte.app.repository.MarketRepository;
import com.br.encarte.app.service.MarketService;
import com.br.encarte.app.specification.MarketSpecification;

import jersey.repackaged.com.google.common.collect.Lists;

@Controller
public class MarketController {
	
	@Autowired
	private MarketRepository marketRepository;
	
	@Autowired
	private MarketService marketService;
	
    @RequestMapping("/gerenciamentoMercados")
    public String mercado(Model model) {
        return "gerenciamentoMercados";
    }

    @RequestMapping("/TelaDeCadastroDeMercados")
    public String cadastro_mercado(Model model) {
        return "TelaDeCadastroDeMercados";
    }

    @RequestMapping("/TelaDeAlterarMercados")
    public String alterar_mercado(Model model) {
        return "TelaDeAlterarMercados";
    }

    @RequestMapping("/telaDeExcluirMercado")
    public String excluir_mercado(Model model) {
        return "telaDeExcluirMercado";
    }

    @RequestMapping("/ListaMercados")
    public String lista_mercado(Model model) {
        return "ListaMercados";
    }
    
    @RequestMapping("/ListaMercadosUsuarios")
    public String lista_mercado_Usuarios(Model model) {
        return "ListaMercadosUsuarios";
    }
    
    @RequestMapping("/Principal")
    public String Principal(Model model) {
        return "Principal";
    }
    
    @RequestMapping("/paginamercado/{idMarket}")
    public String PaginaMercado(Model model, @PathVariable Long idMarket) {
    	
    	model.addAttribute("listaEncartes", marketService.montarListaEncarte(idMarket));
        return "PaginaMercado";
    }
    
    @RequestMapping("/paginamercado")
    public String PaginaMercado() {
    	return "PaginaMercado";
    }
    
    @RequestMapping("/inicialMercado")
    public String inicial_Mercado(Model model) {
        return "inicialMercado";
    }
    
    @ResponseBody
    @GetMapping("/market/{name}")
    public List<Market> findByName(@PathVariable String name) {
    	return marketRepository.findAll(MarketSpecification.name(name));
    }
 
    @ResponseBody
    @GetMapping("/market/username/{username}")
    public List<Market> findByUsername(@PathVariable String username) {
    	return marketRepository.findAll(MarketSpecification.username(username));
    }
    
    @ResponseBody
    @GetMapping("/market")
    public List<Market> findAll() {
    	return Lists.newArrayList(marketRepository.findAll());
    }
}