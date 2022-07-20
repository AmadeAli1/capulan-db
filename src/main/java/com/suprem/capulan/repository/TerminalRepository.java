package com.suprem.capulan.repository;

import com.suprem.capulan.model.location.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TerminalRepository extends JpaRepository<Terminal, Integer> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO TERMINAL (NOME, REGIAO) VALUES (?1,?2)", nativeQuery = true)
    Integer insert(String nome, String regiao);
}