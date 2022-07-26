package com.suprem.capulan.model.relationship;

import com.suprem.capulan.model.produto.Produto;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "HISTORICO_VENDAS")
public class HistoricoVenda {
    @Id
   @Column(name = "ID_HISTORICO", nullable = false)
    private Integer id;

    @Column(name = "QUANTIDADE", nullable = false)
    private Integer quantidade;

    @Column(name = "DATA_VENDA", nullable = false)
    private LocalDate dataVenda;

    @Column(name = "PRECO", nullable = false)
    private Integer preco;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_PRODUTO", nullable = false)
    @ToString.Exclude
    private Produto idProduto;

    @OneToMany(mappedBy = "historicoVenda")
    @ToString.Exclude
    private Set<FuncionarioHistorico> funcionarioHistoricos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "cliente")
    @ToString.Exclude
    private Set<ClienteHistorico> clienteHistoricos = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        HistoricoVenda that = (HistoricoVenda) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}