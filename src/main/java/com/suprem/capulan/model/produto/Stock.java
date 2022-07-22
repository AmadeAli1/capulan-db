package com.suprem.capulan.model.produto;

import com.suprem.capulan.model.location.Terminal;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
@ToString
@RequiredArgsConstructor
@Table(name = "STOCK")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STOCK_ID")
    @SequenceGenerator(name = "STOCK_ID", sequenceName = "STOCK_ID", allocationSize = 1)
    @Column(name = "ID_STOCK", nullable = false)
    private Integer id;

    @Column(name = "QUANTIDADE", nullable = false)
    private Long quantidade;

    @Column(name = "DATA_CHEGADA", nullable = false)
    private LocalDate dataChegada;

    @Column(name = "PRECO", nullable = false)
    private Long preco;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_TERMINAL", nullable = false)
    @ToString.Exclude
    private Terminal idTerminal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_FORNECEDOR")
    @ToString.Exclude
    private Fornecedor idFornecedor;

    public Stock(Long quantidade, Long preco) {
        this.quantidade = quantidade;
        this.dataChegada = LocalDate.now();
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Stock stock = (Stock) o;
        return id != null && Objects.equals(id, stock.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}