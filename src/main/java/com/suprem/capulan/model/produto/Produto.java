package com.suprem.capulan.model.produto;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "PRODUTO")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUTO_ID")
    @SequenceGenerator(name = "PRODUTO_ID", sequenceName = "PRODUTO_ID", allocationSize = 1)
    @Column(name = "ID_PRODUTO", nullable = false)
    private Integer id;

    @Column(name = "NOME", nullable = false, length = 50)
    private String nome;

    @Column(name = "PRECO", nullable = false)
    private long preco;

    @Column(name = "QUANTIDADE_DISPONIVEL", nullable = false)
    private Long quantidadeDisponivel;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_CATEGORIA", nullable = false)
    private Categoria idCategoria;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_STOCK", nullable = false)
    private Stock idStock;

    public Integer getId() {
        return id;
    }


}