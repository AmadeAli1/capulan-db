package com.suprem.capulan.repository;

import com.suprem.capulan.model.produto.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StockRepository extends JpaRepository<Stock, Integer> {
}