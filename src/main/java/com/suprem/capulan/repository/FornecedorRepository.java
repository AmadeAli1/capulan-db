package com.suprem.capulan.repository;

import com.suprem.capulan.model.produto.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {
    @Query("select max(id) as MAXID from Fornecedor ")
    Integer MAXID();
}