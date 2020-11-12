package br.com.sa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerTelaProdutos {

    // Controller provisório

    @GetMapping("/telaProdutos")
    public String getTelaProdutos(){
        return "telaProdutos";
    }

    @GetMapping("/finalizarCompra")
    public String getTelaFinalizarCompra(){
        return "finalizarCompra";
    }
}
