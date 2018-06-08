package com.br.encarte.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.br.encarte.app.entity.Encarte;
import com.br.encarte.app.repository.EncarteRepository;
import com.br.encarte.app.specification.EncarteSpecification;

import jersey.repackaged.com.google.common.collect.Lists;

@Controller
public class EncarteController {

	@Autowired
	private EncarteRepository encarteRepository;
	
    @RequestMapping("/gerenciamentoEncartes")
    public String encarte(Model model) {
        return "gerenciamentoEncartes";
    }

    @RequestMapping("/TelaDeCadastroDeEncartes")
    public String cadastro_encarte(Model model) {
        return "TelaDeCadastroDeEncartes";
    }

    @RequestMapping("/TelaDeAlterarEncartes")
    public String alterar_encarte(Model model) {
        return "TelaDeAlterarEncartes";
    }

    @RequestMapping("/telaDeExcluirEncarte")
    public String excluir_encarte(Model model) {
        return "telaDeExcluirEncarte";
    }

    @RequestMapping("/ListaEncartes")
    public String lista_encarte(Model model) {
        return "ListaEncartes";
    }
    
    @RequestMapping("/ListaEncartesUsuarios")
    public String lista_encarte_Usuarios(Model model) {
        return "ListaEncartesUsuarios";
    }
    
    @RequestMapping("/inicial")
    public String inicial(Model model) {
        return "inicial";
    }
    
    @ResponseBody
    @GetMapping("/encarte/{name}")
    public List<Encarte> findByName(@PathVariable String name) {
    	return encarteRepository.findAll(EncarteSpecification.name(name));
    }
    
    @ResponseBody
    @GetMapping("/encarte")
    public List<Encarte> findAll() {
    	return Lists.newArrayList(encarteRepository.findAll());
    }
    
    @GetMapping("/market/{idMarket}/encarte")
    @ResponseBody
    public List<Encarte> findEncarteByMarket(@PathVariable Long idMarket) {
    	Specifications<Encarte> where = null;
    	where = Specifications.where(EncarteSpecification.marketId(idMarket));

    	return encarteRepository.findAll(where);
    }
    
    @GetMapping("/market/{idMarket}/encarte/{encarteName}")
    @ResponseBody
    public List<Encarte> findByEncarteMarket(@PathVariable Long idMarket, @PathVariable String encarteName) {
    	Specifications<Encarte> where = null;
    	where = Specifications.where(EncarteSpecification.name(encarteName));
    	where = where.and(Specifications.where(EncarteSpecification.marketId(idMarket)));
    	
    	return encarteRepository.findAll(where);
    }

}
