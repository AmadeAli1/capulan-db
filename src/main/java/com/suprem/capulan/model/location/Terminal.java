package com.suprem.capulan.model.location;

import com.suprem.capulan.model.user.Usuario;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Terminal {
    @Id
    @Column(name = "id_terminal", nullable = false)
    private Integer id = 0;

    @Column(nullable = false, length = 50)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "regiao", nullable = false, length = 50)
    private Region region;

    @OneToMany(mappedBy = "idTerminal")
    private Set<Usuario> usuarios = new LinkedHashSet<>();

    public Terminal(String nome, Region region) {
        this.nome = nome;
        this.region = region;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Terminal terminal = (Terminal) o;
        return id != null && Objects.equals(id, terminal.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
