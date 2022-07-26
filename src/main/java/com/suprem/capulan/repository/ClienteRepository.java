package com.suprem.capulan.repository;

import com.suprem.capulan.model.user.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByEmail(String email);

    @Query("select (count(c) > 0) from Cliente c where c.email = :email")
    Boolean existsByEmail(@Param("email") String email);

    @Query("select max(id) as MAXID from Cliente ")
    Integer MAXID();
}