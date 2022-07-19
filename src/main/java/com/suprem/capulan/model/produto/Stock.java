package com.suprem.capulan.model.produto;

import com.suprem.capulan.model.location.Terminal;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
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
    private Terminal idTerminal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_FORNECEDOR")
    private Fornecedor idFornecedor;

}