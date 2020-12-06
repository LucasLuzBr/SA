package br.com.sa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sa.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    public Usuario findByLogin(String login);

}
