package com.devsalmeida.techstore.controller;

import com.devsalmeida.techstore.entities.Produto;
import com.devsalmeida.techstore.model.Resultado;
import com.devsalmeida.techstore.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/techstore")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "")
    public String inicio(){
        return "Bem vindo a TechStore!";
    }

    @GetMapping(value = "/produtos")
    public List<Produto> listarProdutos(){
        return produtoService.listarProdutos();
    }

    @GetMapping(value = "/produto")
    public Produto listarProdutoPorcodigo(@RequestParam Long codigo){
        return produtoService.filtrarProdutoPorcodigo(codigo);
    }

    @PostMapping(value = "/cadastrar-produto")
    public Produto cadastrarProduto(@Valid @RequestBody Produto produto){
        return produtoService.cadastrarProduto(produto);
    }

    @PutMapping(value = "/alterar-produto")
    public Produto alterarProduto(@Valid @RequestBody Produto produto){
        return produtoService.alterarProduto(produto);
    }

    @DeleteMapping(value = "deletar-produto")
    public Resultado deletarProduto(@RequestParam Long codigo){
        Resultado resultado = new Resultado();
        try {
            Produto produto = produtoService.filtrarProdutoPorcodigo(codigo);
            produtoService.deletarProduto(produto);
            resultado.setResultado("Exclusão executada com sucesso!");
        }catch (Exception e){
            resultado.setResultado("Erro ao excluir, causa: " + e.getMessage());
        }
        return resultado;
    }



}
