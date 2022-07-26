package com.suprem.capulan.repository;

import com.suprem.capulan.model.relationship.Encomenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EncomendaRepository extends JpaRepository<Encomenda, Integer> {
    @Query("select max(id) as MAXID from Encomenda ")
    Integer MAXID();
}