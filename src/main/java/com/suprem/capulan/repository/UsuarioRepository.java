package com.suprem.capulan.repository;

import com.suprem.capulan.model.user.Usercliente;
import com.suprem.capulan.model.user.Usuario;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("select u from Usuario u where u.bi = ?1")
    Optional<Usuario> findByBi(String bi);

    @Query("select a from Usercliente a")
    List<Usercliente> findAllCliente();

}