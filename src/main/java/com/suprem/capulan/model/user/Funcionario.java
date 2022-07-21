package com.suprem.capulan.model.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FUNCIONARIO_ID")
    @SequenceGenerator(name = "FUNCIONARIO_ID", sequenceName = "FUNCIONARIO_ID", initialValue = 20220000, allocationSize = 1)
    @Column(name = "ID_FUNCIONARIO", nullable = false)
    private Integer id;

    @Column(name = "SALARIO", nullable = false)
    private Long salario;

    @Column(name = "AREA_TRABALHO", nullable = false, length = 50)
    private String areaTrabalho;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    @ToString.Exclude
    private Usuario idUsuario;


    public Funcionario(Long salario, String areaTrabalho, Usuario idUsuario) {
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