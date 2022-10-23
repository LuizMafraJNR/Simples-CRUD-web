package br.univille.novostalentos.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.novostalentos.entity.Produto;
import br.univille.novostalentos.service.CidadeService;
import br.univille.novostalentos.service.ProdutoService;

@RequestMapping("/produto")
@Controller
public class ProdutoController {

    @Autowired
    private ProdutoService service;
    @Autowired
    private CidadeService cidadeService;

    @GetMapping()
    public ModelAndView mostrar(){
        var listaProdutos = service.getAll();
        return new ModelAndView("produto/index","listaProdutos", listaProdutos);
    }

    @GetMapping("/novo")
    public ModelAndView novo(){
        var produto = new Produto();
        var listaCidades = cidadeService.getAll();
        HashMap<String, Object> dados = new HashMap<>();
        dados.put("produto", produto);
        dados.put("listaCidades", listaCidades);
        return new ModelAndView("produto/form", dados);
    }

    @PostMapping(params = "form")
    public ModelAndView salvar(Produto produto){
        service.salvar(produto);
        var listaCidades = cidadeService.getAll();
        HashMap<String, Object> dados =  new HashMap<>();
        dados.put("produto", produto);
        dados.put("listaCidades", listaCidades);
        return new ModelAndView("redirect:/produto");
    }
}
