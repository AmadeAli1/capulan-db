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
@Table(name = "FORNECEDOR")
public class Fornecedor {
    @Id
     @Column(name = "ID_FORNECEDOR", nullable = false)
    private Integer id;

    @Column(name = "NOME_EMPRESA", nullable = false, length = 50)
    private String nomeEmpresa;

    @Column(name = "CONTACTO", nullable = false, length = 50)
    private String contacto;

    @Column(name = "EMAIL", nullable = false, length = 50)
    private String email;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "idFornecedor", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Stock> stocks = new LinkedHashSet<>();

    public Fornecedor(String nomeEmpresa, String contacto, String email) {
        this.nomeEmpresa = nomeEmpresa;
        this.contacto = contacto;
        this.email = email;
    }

    public Set<Stock> getStocks() {
        return stocks;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Fornecedor that = (Fornecedor) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}