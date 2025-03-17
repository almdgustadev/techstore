package com.devsalmeida.techstore.controller;

import com.devsalmeida.techstore.entities.Produto;
import com.devsalmeida.techstore.model.Resultado;
import com.devsalmeida.techstore.service.ProdutoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import org.hibernate.sql.NullnessRestriction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
// criar classe de excecao

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
    public  ResponseEntity<String> listarProdutos(){
        List<Produto> listaProdutos = produtoService.listarProdutos();
        if (listaProdutos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há produtos cadastrados");
        }
        return ResponseEntity.ok("Produtos cadastrados\n" + listaProdutos);

    }

    @GetMapping(value = "/produtos/{codigo}")
    public ResponseEntity<String> listarProdutoPorCodigo(@PathVariable Long codigo){
        Produto produto = produtoService.filtrarProdutoPorcodigo(codigo);
        if (produto == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum produto encontrado com este código!");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body("Produto encontrado! \n" + produto);
    }

    @PostMapping(value = "/produtos")
    public ResponseEntity<String> cadastrarProduto(@Valid @RequestBody Produto produto){
        produtoService.cadastrarProduto(produto);
        return ResponseEntity.ok("Produto cadastrado com sucesso!");
    }

    @PutMapping(value = "/produtos/{codigo}")
    public ResponseEntity<String> alterarProduto(@PathVariable Long codigo ,@Valid @RequestBody Produto novoProduto){
        Produto produto = produtoService.filtrarProdutoPorcodigo(codigo);
        if (produto == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao atualizar! Produto não encontrado");
        }
        novoProduto.setCodigo(codigo);
        produtoService.alterarProduto(novoProduto);
        return ResponseEntity.ok("Produto atualizado com sucesso!");

    }

    @DeleteMapping(value = "/produtos/{codigo}")
    public ResponseEntity<String> deletarProduto(@PathVariable Long codigo){
        Produto produto = produtoService.filtrarProdutoPorcodigo(codigo);
        if (produto != null){
            produtoService.deletarProduto(produto);
            return ResponseEntity.ok("Produto deletado com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
    }



}
