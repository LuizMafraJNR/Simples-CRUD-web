package br.univille.novostalentos.controller;

import java.util.HashMap;

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
import br.univille.novostalentos.service.CidadeService;
import br.univille.novostalentos.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;
    @Autowired
    private CidadeService cidadeService;
    
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
        //Precisamos de uma lista de cidades.
        var listaCidades = cidadeService.getAll();
        // Nova coleção chamado HashMap
        /*
         * é usado para passarmos diversas informações usando
         * uma "lista", não é uma lista, mas é quase isso e serve
         * para passar mais de umas informação na tela
         */
        HashMap<String,Object> dados = new HashMap<>();
        dados.put("cliente", cliente);
        dados.put("listaCidades", listaCidades);
        return new ModelAndView("cliente/form", dados);
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
        var listaCidades = cidadeService.getAll();
        HashMap<String, Object> dados2 = new HashMap<>();
        dados2.put("cliente", umCliente);
        dados2.put("listaCidades", listaCidades);
        return new ModelAndView("cliente/form", dados2);
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id){

        service.delete(id);

        return new ModelAndView("redirect:/clientes");
    }



}