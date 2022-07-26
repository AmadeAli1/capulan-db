package com.suprem.capulan.model.relationship;

import com.suprem.capulan.model.location.Terminal;
import com.suprem.capulan.model.produto.Produto;
import com.suprem.capulan.model.user.Funcionario;
import com.suprem.capulan.model.user.Usuario;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
@Table(name = "ENCOMENDA")
public class Encomenda {
    @Id
    @Column(name = "ID_ENCOMENDA", nullable = false)
    private Integer id;

    @Column(name = "DATA_ENTREGA", nullable = true)
    private LocalDate dataEntrega;

    @Column(name = "QUANTIDADE", nullable = false)
    private Long quantidade;

    @Column(name = "PRECO", nullable = false)
    private Long preco;

    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO", nullable = false, length = 50)
    private EncomendaEstado estado = EncomendaEstado.PENDENTE;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    @ToString.Exclude
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_PRODUTO", nullable = false)
    @ToString.Exclude
    private Produto produto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_TERMINAL", nullable = false)
    @ToString.Exclude
    private Terminal terminal;

    public Encomenda(Long quantidade) {
        this.quantidade = quantidade;
    }


    @ManyToMany
    @JoinTable(name = "FUNCIONARIO_ENCOMENDA",
            joinColumns = @JoinColumn(name = "ID_ENCOMENDA"),
            inverseJoinColumns = @JoinColumn(name = "ID_FUNCIONARIO"))
    @ToString.Exclude
    private Set<Funcionario> funcionarios = new LinkedHashSet<>();


    public void addFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Encomenda encomenda = (Encomenda) o;
        return id != null && Objects.equals(id, encomenda.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public enum EncomendaEstado {
        ENTREGUE,
        PENDENTE,
        ENVIANDO,
        CANCELADO
    }
}