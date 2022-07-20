package com.suprem.capulan.model.user;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario {
    @Id
    @Column(name = "ID_FUNCIONARIO", nullable = false)
    private Integer id;

    @Column(name = "SALARIO", nullable = false)
    private Float salario;

    @Column(name = "AREA_TRABALHO", nullable = false, length = 50)
    private String areaTrabalho;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    @ToString.Exclude
    private Usuario idUsuario;


    public Funcionario(Float salario, String areaTrabalho, Usuario idUsuario) {
        this.salario = salario;
        this.areaTrabalho = areaTrabalho;
        this.idUsuario = idUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Funcionario that = (Funcionario) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}