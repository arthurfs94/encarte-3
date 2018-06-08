package com.br.encarte.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.br.encarte.app.entity.Encarte;
import com.br.encarte.app.entity.Product;
import com.br.encarte.app.entity.ResultadoPesquisa;
import com.br.encarte.app.repository.EncarteRepository;
import com.br.encarte.app.repository.ProductRepository;
import com.br.encarte.app.specification.ProductSpecification;

import jersey.repackaged.com.google.common.collect.Lists;

@Controller
public class ProductController {

	@Autowired
	private EncarteRepository repository;
	
	@Autowired
	private ProductRepository prodRepo;

	@GetMapping(path = "pesquisaEncarte")
	@ResponseBody
	private ResultadoPesquisa buscarEncartes(@RequestParam(value = "paramPesquisa")String paramPesquisa) {
		System.out.println("VALOR PARAM :" + paramPesquisa);
		ResultadoPesquisa res = new ResultadoPesquisa();
		res.setEncartes(repository.findAllEncarteParam(paramPesquisa.toUpperCase()));
		return res;
	}

	@GetMapping(path = "pesquisaFiltro")
	@ResponseBody
	private ResultadoPesquisa pesquisar(@RequestParam(value = "paramPesquisa", required = false) String paramPesquisa,
			@RequestParam(value = "filtro", required = false) String filtro,
			@RequestParam(value = "localidade", required = false) String localidade) {
		ResultadoPesquisa res = new ResultadoPesquisa();
		System.out.println("PARAM: "+paramPesquisa);
		System.out.println("FILTRO: "+filtro);
		System.out.println(
				repository.findEncarteByParamFiltro(paramPesquisa != null ? paramPesquisa.toUpperCase() : paramPesquisa,
						filtro!=null?filtro.toUpperCase():filtro,localidade!=null? localidade.toUpperCase():localidade));
		res.setEncartes(
				repository.findEncarteByParamFiltro(paramPesquisa != null ? paramPesquisa.toUpperCase() : paramPesquisa,
						filtro!=null?filtro.toUpperCase():filtro,localidade!=null? localidade.toUpperCase():localidade));
		
		res.setProdutos(prodRepo.findProductByParamFiltro(paramPesquisa!=null?paramPesquisa.toUpperCase():paramPesquisa
				,filtro!=null?filtro.toUpperCase():filtro));
		return res;
	}
	
	@GetMapping(path = "pesquisaProdutos")
	@ResponseBody
	private List<Product> buscarProdutos(@RequestParam(value = "name")String name) {
		return prodRepo.findAllByName(name);
	}


	@RequestMapping("/gerenciamentoProduto")
    public String produto(Model model) {
        return "gerenciamentoProduto";
    }

    @RequestMapping("/TelaDeCadastroDeProduto")
    public String cadastro_produto(Model model) {
        return "TelaDeCadastroDeProduto";
    }

    @RequestMapping("/TelaDeAlterarProduto")
    public String alterar_produto(Model model) {
        return "TelaDeAlterarProduto";
    }

    @RequestMapping("/telaDeExcluirProduto")
    public String excluir_produto(Model model) {
    	Encarte encarte = new Encarte();
    	model.addAttribute("name",encarte.getName());
        return "telaDeExcluirProduto";
    }

    @RequestMapping("/ListaProdutos")
    public String lista_produto(Model model) {
        return "ListaProdutos";
    }
    
    @RequestMapping("/ListaProdutosUsuarios")
    public String lista_produto_Usuarios(Model model) {
        return "ListaProdutosUsuarios";
    }
    
    @GetMapping("/product/{name}")
    @ResponseBody
    public List<Product> findByName(@PathVariable String name) {
    	return prodRepo.findAll(ProductSpecification.name(name));
    }
    
    @ResponseBody
    @GetMapping("/product")
    public List<Product> findAll() {
    	return Lists.newArrayList(prodRepo.findAll());
    }
    
    @GetMapping("/market/{idMarket}/product")
    @ResponseBody
    public List<Product> findProductByMarket(@PathVariable Long idMarket) {
    	Specifications<Product> where = null;
    	where = Specifications.where(ProductSpecification.marketId(idMarket));
    	return prodRepo.findAll(where);
    }
    
    @GetMapping("/market/{idMarket}/product/{prodName}")
    @ResponseBody
    public List<Product> findByProductMarket(@PathVariable Long idMarket, @PathVariable String prodName) {
    	Specifications<Product> where = null;
    	where = Specifications.where(ProductSpecification.name(prodName));
    	where = where.and(Specifications.where(ProductSpecification.marketId(idMarket)));
    	
    	return prodRepo.findAll(where);
    }
    
}
