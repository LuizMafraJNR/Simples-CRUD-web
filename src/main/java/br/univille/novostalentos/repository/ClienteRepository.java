package br.univille.novostalentos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.univille.novostalentos.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    public List<Cliente> findByNomeIgnoreCaseContaining(@Param("nome") String nome);
}
