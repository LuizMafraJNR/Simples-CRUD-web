package br.univille.novostalentos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/produto")
@Controller
public class ProdutoController {
    @GetMapping()
    public ModelAndView mostrar(){
        return new ModelAndView("produto/index");
    }
}
