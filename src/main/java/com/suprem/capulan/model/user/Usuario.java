package com.suprem.capulan.model.user;

import com.suprem.capulan.model.location.Terminal;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "USUARIO")
public class Usuario {
    @Id
    @Column(name = "ID_USUARIO", nullable = false)
    private Integer id;

    @Column(name = "NOME", nullable = false, length = 50)
    private String nome;

    @Column(name = "BI", nullable = false, length = 13)
    private String bi;

    @Enumerated(EnumType.STRING)
    @Column(name = "SEXO", length = 10)
    private Genre sexo;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO", nullable = false, length = 15)
    private UserType userType;

    @Column(name = "SENHA", nullable = false, length = 50)
    private String senha;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_TERMINAL", nullable = false)
    @ToString.Exclude
    private Terminal idTerminal;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Usuario usuario = (Usuario) o;
        return id != null && Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}