package com.br.encarte.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EncarteController {

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

}
