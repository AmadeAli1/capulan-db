package com.suprem.capulan.repository;

import com.suprem.capulan.model.produto.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    @Query("select max(id) as MAXID from Stock ")
    Integer MAXID();
}