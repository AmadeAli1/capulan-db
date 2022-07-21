package com.suprem.capulan.model.relationship;

import com.suprem.capulan.model.user.Funcionario;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "FUNCIONARIO_HISTORICO")
public class FuncionarioHistorico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FUNCIONARIO_HISTOCO_ID")
    @SequenceGenerator(name = "FUNCIONARIO_HISTOCO_ID", sequenceName = "FUNCIONARIO_HISTOCO_ID", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_HISTORICO", nullable = false)
    @ToString.Exclude
    private HistoricoVenda historicoVenda;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_FUNCIONARIO", nullable = false)
    @ToString.Exclude
    private Funcionario funcionario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FuncionarioHistorico that = (FuncionarioHistorico) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}