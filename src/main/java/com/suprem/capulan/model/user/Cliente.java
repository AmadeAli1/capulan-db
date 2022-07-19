package com.suprem.capulan.model.user;

import com.suprem.capulan.model.relationship.ClienteHistorico;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@RequiredArgsConstructor
@Table(name = "CLIENTE")
public class Cliente {
    @Id
    @Column(name = "ID_CLIENTE", nullable = false)
    private Integer id;

    @Column(name = "EMAIL", nullable = false, length = 50)
    private String email;

    @Column(name = "CODIGO_POSTAL", nullable = false, length = 10)
    private String codigoPostal;

    @Column(name = "CIDADE", nullable = false, length = 50)
    private String cidade;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    @ToString.Exclude
    private Usuario idUsuario;

    @OneToMany(mappedBy = "cliente")
    @ToString.Exclude
    private Set<ClienteHistorico> clienteHistoricos = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cliente cliente = (Cliente) o;
        return id != null && Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}