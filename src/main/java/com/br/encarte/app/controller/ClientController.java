package com.br.encarte.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.br.encarte.app.entity.Client;
import com.br.encarte.app.service.ClientService;

@Controller
public class ClientController {
	
	@Autowired
	ClientService clientService; 

    @RequestMapping("/gerenciamentoUsuarios")
    public String usuario(Model model) {
        return "gerenciamentoUsuarios";
    }

    @RequestMapping("/TelaDeCadastroDeUsuarios")
    public String cadastro_usuario(Model model) {
        return "TelaDeCadastroDeUsuarios";
    }

    @RequestMapping("/TelaDeAlterarUsuarios")
    public String alterar_usuario(Model model) {
        return "TelaDeAlterarUsuarios";
    }

    @RequestMapping("/telaDeExcluirUsuario")
    public String excluir_usuario(Model model) {
        return "telaDeExcluirUsuario";
    }

    @RequestMapping("/ListaUsuarios")
    public String lista_usuario(Model model) {
        return "ListaUsuarios";
    }

    @ResponseBody
    @GetMapping("/client/username/{username}")
    public List<Client> findByUsername(@PathVariable String username) {
    	return clientService.findByUsername(username);
    }

}
