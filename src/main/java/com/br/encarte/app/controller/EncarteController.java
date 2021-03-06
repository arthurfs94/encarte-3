package com.br.encarte.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.br.encarte.app.entity.Encarte;
import com.br.encarte.app.entity.EncarteRequest;
import com.br.encarte.app.repository.EncarteRepository;
import com.br.encarte.app.service.EncarteService;
import com.br.encarte.app.specification.EncarteSpecification;

import jersey.repackaged.com.google.common.collect.Lists;

@Controller
public class EncarteController {
	
	@Autowired
	private EncarteService encarteService; 
	
	@Autowired
	private EncarteRepository encarteRepository;
	
    @RequestMapping("/gerenciamentoencartes")
    public String encarte(Model model) {
        return "gerenciamentoEncartes";
    }
    
    @RequestMapping("/encarteregistration")
    public String cadastro_encarte(Model model) {
        return "TelaDeCadastroDeEncartes";
    }

    @RequestMapping("/alterarencartes/{idEncarte}")
    public String alterar_encarte(
    		Model model,
    		@PathVariable Long idEncarte) {
    	
    	model.addAttribute("idEncarte", idEncarte);
        return "TelaDeAlterarEncartes";
    }
    
    @RequestMapping("/excluirencartes/{idEncarte}")
    public String excluirEncarte(
    		Model model,
    		@PathVariable Long idEncarte) {
    	
    	model.addAttribute("idEncarte", idEncarte);
    	return "telaDeExcluirEncarte";
    }
    
    @RequestMapping("/listaEncartesAlterar")
    public String listaEncartesAlterar(Model model) {
    	return "listaEncartesAlterar";
    }

    @RequestMapping("/telaDeExcluirEncarte")
    public String excluir_encarte(Model model) {
        return "telaDeExcluirEncarte";
    }

    @RequestMapping("/listaencartes")
    public String lista_encarte(Model model) {
        return "ListaEncartes";
    }
    
    @RequestMapping("/listaencartesproducts")
    public String encarteProducts(Model model) {
    	return "ListaEncartesProducts";
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
    @GetMapping("/Principal/encartename/{name}")
    public List<Encarte> findByNamePrincipal(@PathVariable String name) {
    	Specifications<Encarte> where = Specifications.where(EncarteSpecification.name(name));
    	where = where.and(EncarteSpecification.dataLimite());
    	return encarteRepository.findAll(where);
    }
    
    @ResponseBody
    @GetMapping("/Principal/encartename")
    public List<Encarte> findByNamePrincipal() {
    	return encarteRepository.findAll(EncarteSpecification.dataLimite());
    }
    
    @ResponseBody
    @GetMapping("/encarte")
    public List<Encarte> findAll() {
    	return Lists.newArrayList(encarteRepository.findAll());
    }
    
    @GetMapping("/market/{idMarket}/encarte")
    @ResponseBody
    public List<Encarte> findEncarteByMarket(@PathVariable Long idMarket) {
    	Specifications<Encarte> where = Specifications.where(EncarteSpecification.marketId(idMarket));
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
    
    @GetMapping("/market/{idMarket}/idencarte/{idEncarte}")
    @ResponseBody
    public List<Encarte> findByIdEncarteMarket(@PathVariable Long idMarket, @PathVariable Long idEncarte) {
    	Specifications<Encarte> where = null;
    	where = Specifications.where(EncarteSpecification.id(idEncarte));
    	where = where.and(Specifications.where(EncarteSpecification.marketId(idMarket)));
    	
    	return encarteRepository.findAll(where);
    }
    
    @GetMapping("/paginamercado/{idMarket}/encartename/{encarteName}")
    @ResponseBody
    public List<Encarte> findByMarketEncarteName(@PathVariable Long idMarket, @PathVariable String encarteName) {
    	Specifications<Encarte> where = null;
    	where = Specifications.where(EncarteSpecification.name(encarteName));
    	where = where.and(Specifications.where(EncarteSpecification.marketId(idMarket)));
    	where = where.and(Specifications.where(EncarteSpecification.dataLimite()));
    	
    	return encarteRepository.findAll(where);
    }
    
    @GetMapping("/paginamercado/{idMarket}/encartename")
    @ResponseBody
    public List<Encarte> findAllByMarketEncarte(@PathVariable Long idMarket) {
    	Specifications<Encarte> where = Specifications.where(EncarteSpecification.marketId(idMarket));
    	where = where.and(Specifications.where(EncarteSpecification.dataLimite()));
    	return encarteRepository.findAll(where);
    }
    
    @PostMapping("/encarte/cadastrar")
    @ResponseBody
    public Encarte saveEncarte(@RequestBody EncarteRequest encarte) {
    	return encarteRepository.save( encarteService.convert(encarte));
    }
    
    @PostMapping("/productsencarte")
    @ResponseBody
    public Encarte saveProductsEncarte(@RequestBody EncarteRequest encarteRequest) {
    
    	encarteService.save(encarteRequest);
    	return null;
    }
    
    @RequestMapping("/listaencartesexcluir")
    public String listaEncartesExcluir(Model model) {
    	return "listaEncartesExcluir";
    }
    
    @DeleteMapping("/encarte/excluir/{idProd}")
    @ResponseBody
    public Boolean deleteEncarte(@PathVariable Long idProd) {
    	
    	encarteRepository.delete(idProd);
    	return true;
    }
    
}
