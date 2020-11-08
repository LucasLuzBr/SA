package br.com.sa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerTelaProdutos {
    
    @GetMapping("/")
    public String getTelaProdutos(){
        return "telaProdutos";
    }
}
