package br.com.sa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.sa.model.Usuario;
import br.com.sa.repository.UsuarioRepository;

@Controller
public class ControllerTelaProdutos {

    // Controller provisório

    @Autowired
    private UsuarioRepository usuarioRepository;

    // @GetMapping("/")
    // public String getIndex(){
    //     return "index";
    // }

    @GetMapping("/login")
    public String getLgin(){
        return "login";
    }

    @GetMapping("/novoCadastro")
    public String getNovoCadastro(Model model){
        model.addAttribute("usuario", new Usuario());

        return "novoCadastro";
    }

    @PostMapping("/usuario/save")
    public String saveUsuario(Usuario usuario){

        if (usuarioRepository.findByLogin(usuario.getLogin()) == null){

            usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha())); 

            usuarioRepository.save(usuario);

        } else {
            System.out.println("Usuário já existente!");
        }

        
        return "redirect:/login";
    }

    @GetMapping("/")
    public String getTelaProdutos(){
        return "telaProdutos";
    }

    @GetMapping("/finalizarCompra")
    public String getTelaFinalizarCompra(){
        return "finalizarCompra";
    }
}
