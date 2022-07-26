package com.suprem.capulan.model.user;

import lombok.Getter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Objects;

/**
 * Mapping for DB view
 */
@Entity
@Getter
@Immutable
@Table(name = "USERCLIENTE")
public class Usercliente {
    @Id
    @Column(name = "BI", nullable = false, length = 13)
    private String bi;

    @Column(name = "ID_USUARIO", nullable = false)
    private Integer idUser;

    @Column(name = "ID_TERMINAL", nullable = false)
    private Integer idTerminal;

    @Column(name = "NOME", nullable = false, length = 50)
    private String nome;

    @Column(name = "SENHA", nullable = false, length = 50)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO", nullable = false, length = 15)
    private UserType userType;

    @Enumerated(EnumType.STRING)
    @Column(name = "SEXO", length = 10)
    private Genre sexo;

    @Column(name = "EMAIL", nullable = false, length = 50)
    private String email;

    @Column(name = "CIDADE", nullable = false, length = 50)
    private String cidade;

    @Column(name = "CODIGO_POSTAL", nullable = false, length = 10)
    private String codigoPostal;

    @Column(name = "ID_CLIENTE", nullable = false)
    private Integer id;

    protected Usercliente() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Usercliente that = (Usercliente) o;
        return bi != null && Objects.equals(bi, that.bi);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}