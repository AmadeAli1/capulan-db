package com.suprem.capulan.repository;

import com.suprem.capulan.model.user.Usercliente;
import com.suprem.capulan.model.user.Userfuncionario;
import com.suprem.capulan.model.user.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("select u from Usuario u where u.bi = ?1")
    public Optional<Usuario> findByBi(String bi);

    @Query("select a from Usercliente a")
    List<Usercliente> findAllCliente();

    @Query(value = "select f from Userfuncionario f")
    List<Userfuncionario> findAllFuncionario();

    @Query(value = "select f from Userfuncionario f  where f.id = ?1")
    Optional<Userfuncionario> findFuncionarioById(Integer codigo);

    @Query(value = "select f from Usercliente as f  where f.id = ?1")
    Optional<Usercliente> findClienteById(Integer idUser);

}