package com.suprem.capulan.repository;

import com.suprem.capulan.model.relationship.FuncionarioEncomenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioEncomendaRepository extends JpaRepository<FuncionarioEncomenda, Integer> {
    @Query("select max(id) as MAXID from FuncionarioEncomenda ")
    Integer MAXID();
}