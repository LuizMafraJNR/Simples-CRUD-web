package br.univille.novostalentos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.univille.novostalentos.entity.Cliente;
import br.univille.novostalentos.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;
    
    @GetMapping
    public ModelAndView index(){
        var listaClientes = service.getAll();
        // onde está o html, qual o nome q vou dar, e o objeto criado aqui.
        return new ModelAndView("cliente/index","listaClientes", listaClientes);
        // insert into cliente (nome, endereco, sexo) values ('Ze', 'DAWDAWDA 212', 'Masculino')
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var cliente = new Cliente();
        return new ModelAndView("cliente/form", "cliente",cliente);
    }
    
    @PostMapping(params = "form")
    public ModelAndView save(@Valid Cliente cliente,
                            BindingResult result){ // Metodo para pegar o erro
    // Se tiver erro, volte para a pagina do form.
        if(result.hasErrors()){
            return new ModelAndView("cliente/form", "cliente",cliente);
        }
        service.save(cliente);

        return new ModelAndView("redirect:/clientes");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable Long id){
        var umCliente = service.findById(id);
        return new ModelAndView("cliente/form","cliente",umCliente);
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id){

        service.delete(id);

        return new ModelAndView("redirect:/clientes");
    }



}