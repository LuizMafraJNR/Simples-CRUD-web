package br.univille.novostalentos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.novostalentos.entity.Produto;
import br.univille.novostalentos.repository.ProdutoRepository;
import br.univille.novostalentos.service.ProdutoService;


@Service
public class ProdutoServiceImp implements ProdutoService{
    
    /*
     * Injetando nosso repository 
     */
    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<Produto> getAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }
}
