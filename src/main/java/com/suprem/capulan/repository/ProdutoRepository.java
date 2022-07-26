package com.suprem.capulan.repository;

import com.suprem.capulan.model.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    @Query("select max(id) as MAXID from Produto ")
    Integer MAXID();

}