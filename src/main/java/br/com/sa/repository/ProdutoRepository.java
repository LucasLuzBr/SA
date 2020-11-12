package br.com.sa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sa.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
