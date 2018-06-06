package com.br.encarte.app.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object controller) throws Exception {

        String uri = request.getRequestURI();
        //System.out.println("REQUEST: "+request.getRequestURI());
        //System.out.println("INTERCEPTADOR");
//        if(uri.endsWith("inicial") ||
//                uri.endsWith("efetuaLogin") ||
//                uri.contains("pesquisa")||
//                uri.endsWith("SignIn") ||
//                uri.endsWith("SignInMercado") ||
//                uri.contains("static") ||
//                uri.contains("resources") ||
//                uri.endsWith("ListaProdutosUsuarios") ||
//                uri.endsWith("ListaEncartesUsuarios") ||
//                uri.endsWith("ListaMercadosUsuarios") ||
//                uri.endsWith("PaginaMercado") ||
//                uri.endsWith("Principal") ||
//                uri.endsWith("product") ||
//                uri.endsWith("encarte") ||
//                uri.endsWith("market") ||
//                uri.endsWith("ListaProdutos") ||
//                uri.endsWith("product") ||
//                uri.endsWith("ListaProdutos") ||
//                uri.endsWith("product") ||
//                uri.endsWith("produtos") ||
//                uri.endsWith("client")){
            return true;
//        }
        
//        if(request.getSession()
//                .getAttribute("usuarioLogado") != null) {
//            return true;
//        }
////        else if (request.getSession()
////                .getAttribute("mercadologado") != null) {
////            return true;
////        }
//        else
//        response.sendRedirect("/SignIn");
//        return false;
        
        }
}