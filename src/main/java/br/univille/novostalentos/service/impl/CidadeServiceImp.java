package br.univille.novostalentos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.novostalentos.entity.Cidade;
import br.univille.novostalentos.repository.CidadeRepository;
import br.univille.novostalentos.service.CidadeService;
@Service
public class CidadeServiceImp implements CidadeService{

    @Autowired
    private CidadeRepository cidadeRepository;
    
    @Override
    public List<Cidade> getAll() {
        var listaCidades = cidadeRepository.findAll();
        return listaCidades;
    }

    @Override
    public Cidade save(Cidade cidade) {
        
        return cidadeRepository.save(cidade);
    }
    
    @Override
    public Cidade findById(Long id) {
        var resultado = cidadeRepository.findById(id);
        if(resultado.isPresent()){
            return resultado.get();
        } else {
            return new Cidade();
        }
    }
}
