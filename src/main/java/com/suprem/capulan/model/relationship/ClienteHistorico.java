package com.suprem.capulan.model.relationship;

import com.suprem.capulan.model.user.Cliente;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "CLIENTE_HISTORICO")
public class ClienteHistorico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTE_HISTOCO_ID")
    @SequenceGenerator(name = "CLIENTE_HISTOCO_ID", sequenceName = "CLIENTE_HISTOCO_ID", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_HISTORICO", nullable = false)
    @ToString.Exclude
    private HistoricoVenda historicoVenda;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    @ToString.Exclude
    private Cliente cliente;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ClienteHistorico that = (ClienteHistorico) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}