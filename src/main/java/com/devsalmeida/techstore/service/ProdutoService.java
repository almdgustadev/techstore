package com.devsalmeida.techstore.service;

import com.devsalmeida.techstore.entities.Produto;

import com.devsalmeida.techstore.handler.EmptyStockException;
import com.devsalmeida.techstore.handler.ProductNotFoundException;
import com.devsalmeida.techstore.handler.ProductSaveException;
import com.devsalmeida.techstore.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional(readOnly = true)
    public List<Produto> listarProdutos(){
        List<Produto> result = produtoRepository.findAll();
        if (result.isEmpty()){
            throw new EmptyStockException();
        }else {
            return result;
        }

    }

    @Transactional
    public Produto filtrarProdutoPorcodigo(Long codigo){
        Produto produto = produtoRepository.findByCodigo(codigo);
        if (produto == null){
            throw new ProductNotFoundException();
        }else {
            return produto;
        }

    }

    @Transactional
    public Produto cadastrarProduto(Produto produto){
        if(produtoRepository.existsByNome(produto.getNome())){
            throw new ProductSaveException();
        }
        return produtoRepository.save(produto);
    }

    @Transactional
    public Produto alterarProduto(Produto produto){
        if (produto == null){
            throw new ProductNotFoundException();
        } else {
            return produtoRepository.save(produto);
        }
    }

    @Transactional
    public void deletarProduto(Produto produto){
        if(produto == null){
            throw new ProductNotFoundException();
        }else {
            produtoRepository.delete(produto);
        }

    }
}
