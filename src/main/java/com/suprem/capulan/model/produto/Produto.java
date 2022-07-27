package com.suprem.capulan.model.produto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "PRODUTO")
public class Produto {
    @Id
    @Column(name = "ID_PRODUTO", nullable = false)
    private Integer id;

    @Column(name = "NOME", nullable = false, length = 50)
    private String nome;

    @Column(name = "PRECO", nullable = false)
    private long preco;

    @Column(name = "QUANTIDADE_DISPONIVEL", nullable = false)
    private Long quantidadeDisponivel;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_CATEGORIA", nullable = false)
    private Categoria idCategoria;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_STOCK", nullable = false)
    private Stock idStock;

    public Produto(String nome, long preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Produto produto = (Produto) o;
        return id != null && Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}