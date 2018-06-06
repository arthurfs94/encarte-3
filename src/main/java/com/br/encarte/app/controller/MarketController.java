package com.br.encarte.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MarketController {

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
    
    @RequestMapping("/PaginaMercado")
    public String PaginaMercado(Model model) {
        return "PaginaMercado";
    }
    
    @RequestMapping("/inicialMercado")
    public String inicial_Mercado(Model model) {
        return "inicialMercado";
    }
}
