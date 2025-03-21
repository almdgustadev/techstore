package com.devsalmeida.techstore.controller;

import com.devsalmeida.techstore.entities.Produto;
import com.devsalmeida.techstore.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    public  ResponseEntity<List> listarProdutos(){
        List<Produto> listaProdutos = produtoService.listarProdutos();
        return ResponseEntity.ok(listaProdutos);
    }

    @GetMapping(value = "/produtos/{codigo}")
    public ResponseEntity<Produto> listarProdutoPorCodigo(@PathVariable Long codigo){
        Produto produto = produtoService.filtrarProdutoPorcodigo(codigo);
        return ResponseEntity.ok(produto);
    }

    @PostMapping(value = "/produtos")
    public ResponseEntity<String> cadastrarProduto(@Valid @RequestBody Produto produto){
        produtoService.cadastrarProduto(produto);
        return ResponseEntity.ok("Produto cadastrado com sucesso!");
    }

    @PutMapping(value = "/produtos/{codigo}")
    public ResponseEntity<String> alterarProduto(@PathVariable Long codigo ,@Valid @RequestBody Produto novoProduto){
        Produto produto = produtoService.filtrarProdutoPorcodigo(codigo);
        novoProduto.setCodigo(codigo);
        produtoService.alterarProduto(novoProduto);
        return ResponseEntity.ok("Produto atualizado com sucesso!");

    }

    @DeleteMapping(value = "/produtos/{codigo}")
    public ResponseEntity<String> deletarProduto(@PathVariable Long codigo){
        Produto produto = produtoService.filtrarProdutoPorcodigo(codigo);
        produtoService.deletarProduto(produto);
        return ResponseEntity.ok("Produto deletado com sucesso!");


    }



}
