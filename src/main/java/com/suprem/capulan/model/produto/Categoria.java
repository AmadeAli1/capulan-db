package com.suprem.capulan.model.produto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "CATEGORIA")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORIA_ID")
    @SequenceGenerator(name = "CATEGORIA_ID", sequenceName = "CATEGORIA_ID", allocationSize = 1)
    @Column(name = "ID_CATEGORIA", nullable = false)
    private Integer id;

    @Column(name = "NOME", nullable = false, length = 50)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO", nullable = false)
    private CategoriaType categoriaType;

    @OneToMany(mappedBy = "idCategoria")
    @ToString.Exclude
    private Set<Produto> produtos = new LinkedHashSet<>();

    public Categoria(String nome, CategoriaType categoriaType) {
        this.nome = nome;
        this.categoriaType = categoriaType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Categoria categoria = (Categoria) o;
        return id != null && Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}