package com.suprem.capulan.model.user;

import lombok.Getter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Getter
@Table(name = "USERFUNCIONARIO")
public class Userfuncionario {
    @Id
    @Column(name = "ID_FUNCIONARIO", nullable = false)
    private Integer id;

    @Column(name = "ID_USUARIO", nullable = false)
    private Integer idUser;

    @Column(name = "BI", nullable = false, length = 13)
    private String bi;

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

    @Column(name = "SALARIO", nullable = false)
    private Long salario;

    @Enumerated(EnumType.STRING)
    @Column(name = "AREA_TRABALHO", nullable = false, length = 50)
    private JobArea jobArea;

    protected Userfuncionario() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Userfuncionario that = (Userfuncionario) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}