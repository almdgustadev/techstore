package com.devsalmeida.techstore.service;

import com.devsalmeida.techstore.entities.Produto;
import com.devsalmeida.techstore.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    //criando metodo para passar para o controller
    @Transactional(readOnly = true)
    public List<Produto> listarProdutos(){
        List<Produto> result = produtoRepository.findAll();
        if (result.isEmpty()){
            throw new RuntimeException();
        }else {
            return result;
        }

    }

    @Transactional
    public Produto cadastrarProduto(Produto produto){
        if(produtoRepository.existsByNome(produto.getNome())){
            throw new RuntimeException("Já existe um produto com este nome!");
        }
        return produtoRepository.save(produto);
    }
}
