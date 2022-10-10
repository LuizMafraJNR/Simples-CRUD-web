package br.univille.novostalentos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.novostalentos.entity.Cliente;
import br.univille.novostalentos.repository.ClienteRepository;
import br.univille.novostalentos.service.ClienteService;

@Service
public class ClienteServiceImp implements ClienteService{
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }
    @Override
    public Cliente save(Cliente cliente) {
        
        return clienteRepository.save(cliente);
    }
    @Override
    public Cliente findById(Long id) {
        // A partir do java 8 foi mudado a forma de fazer
        // com o optional<>
        var resultado = clienteRepository.findById(id);
        if (resultado.isPresent()) {
            return resultado.get();
        } else {
            return new Cliente();
        }
    }
    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
        
    }
}
