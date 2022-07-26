package com.suprem.capulan.model.produto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.suprem.capulan.model.location.Terminal;
import lombok.*;
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
    @JsonIgnore
    private Terminal idTerminal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_FORNECEDOR")
    @ToString.Exclude
    @JsonIgnore
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