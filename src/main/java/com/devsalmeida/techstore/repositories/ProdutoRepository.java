package com.devsalmeida.techstore.repositories;

import com.devsalmeida.techstore.entities.Produto;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ProdutoRepository extends CrudRepository<Produto,Long> {

    List<Produto> findAll();

    Produto findByCodigo(Long codigo);

    boolean existsByNome(String nome);

    <S extends Produto> S save(S produto);

    @Override
    void delete(Produto produto);
}
