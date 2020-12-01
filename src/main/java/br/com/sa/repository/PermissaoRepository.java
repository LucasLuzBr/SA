package br.com.sa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sa.model.Permissao;
import br.com.sa.model.Usuario;

public interface PermissaoRepository extends JpaRepository<Permissao, Long>{
    
    public List<Permissao> findByUsuariosIn(Usuario ... usuario);
}

