package com.br.encarte.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientController {

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

}
