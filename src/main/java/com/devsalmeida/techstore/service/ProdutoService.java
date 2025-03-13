package com.devsalmeida.techstore.service;

import com.devsalmeida.techstore.entities.Produto;
import com.devsalmeida.techstore.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    //criando metodo para passar para o controller
    @Transactional(readOnly = true)
    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }
}
