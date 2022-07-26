package com.suprem.capulan.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario {
    @Id
    @Column(name = "ID_FUNCIONARIO", nullable = false)
    private Integer id;

    @Column(name = "SALARIO", nullable = false)
    private Long salario;

    @Enumerated(EnumType.STRING)
    @Column(name = "AREA_TRABALHO", nullable = false, length = 50)
    private JobArea jobArea;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    @ToString.Exclude
    private Usuario idUsuario;


    public Funcionario(Long salario, JobArea areaTrabalho) {
        this.salario = salario;
        this.jobArea = areaTrabalho;
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