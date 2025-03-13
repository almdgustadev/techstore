package com.devsalmeida.techstore.repositories;

import com.devsalmeida.techstore.entities.Produto;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends CrudRepository<Produto,Long> {

    List<Produto> findAll();

    Optional<Produto> findById(Long id);

    @Override
    void delete(Produto produto);

    <S extends Produto> S save(S produto);
}
