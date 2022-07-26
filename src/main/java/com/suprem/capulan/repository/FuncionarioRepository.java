package com.suprem.capulan.repository;

import com.suprem.capulan.model.user.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    @Query("select max(id) as MAXID from Funcionario ")
    Integer MAXID();
}