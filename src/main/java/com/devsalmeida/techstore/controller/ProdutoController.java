package com.devsalmeida.techstore.controller;

import com.devsalmeida.techstore.entities.Produto;
import com.devsalmeida.techstore.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/techstore")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "")
    public @ResponseBody String inicio(){
        return "Bem vindo a TechStore!";
    }

    @GetMapping(value = "/produtos")
    public @ResponseBody List<Produto> listarProdutos(){
        return produtoService.listarProdutos();
    }

    @PostMapping(value = "/cadastrar-produto")
    public @ResponseBody Produto cadastrarProduto(@RequestBody Produto produto){
        return produtoService.cadastrarProduto(produto);
    }

}
