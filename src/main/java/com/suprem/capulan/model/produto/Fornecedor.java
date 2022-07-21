package com.suprem.capulan.model.produto;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "FORNECEDOR")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FORNECEDOR_ID")
    @SequenceGenerator(name = "FORNECEDOR_ID", sequenceName = "FORNECEDOR_ID", allocationSize = 1)
    @Column(name = "ID_FORNECEDOR", nullable = false)
    private Integer id;

    @Column(name = "NOME_EMPRESA", nullable = false, length = 50)
    private String nomeEmpresa;

    @Column(name = "CONTACTO", nullable = false, length = 50)
    private String contacto;

    @Column(name = "EMAIL", nullable = false, length = 50)
    private String email;


    @OneToMany(mappedBy = "idFornecedor")
    private Set<Stock> stocks = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }
}