package com.suprem.capulan.repository;

import com.suprem.capulan.model.relationship.Encomenda;
import com.suprem.capulan.model.views.Encomendaproduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EncomendaRepository extends JpaRepository<Encomenda, Integer> {
    @Query("select max(id) as MAXID from Encomenda ")
    Integer MAXID();

    @Query("select e from Encomendaproduto e")
    List<Encomendaproduto> findAllEncomenda();

}