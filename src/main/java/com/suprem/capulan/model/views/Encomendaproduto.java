package com.suprem.capulan.model.views;

import com.suprem.capulan.model.relationship.Encomenda;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Mapping for DB view
 */
@Getter
@Entity
@Table(name = "ENCOMENDAPRODUTO")
public class Encomendaproduto {
    @Id
    @Column(name = "ID_ENCOMENDA", nullable = false)
    private Long idEncomenda;

    @Column(name = "ID_USUARIO", nullable = false)
    private Long idUsuario;

    @Column(name = "QUANTIDADE", nullable = false)
    private Long quantidade;

    @Column(name = "DATA_ENTREGA")
    private LocalDate dataEntrega;

    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO", nullable = false, length = 50)
    private Encomenda.EncomendaEstado estado;

    @Column(name = "NOME", nullable = false, length = 50)
    private String nome;

    @Column(name = "CLIENTE", nullable = false, length = 50)
    private String cliente;

    @Transient
    private String date;

    @Column(name = "PRECO", nullable = false)
    private Long preco;

    public String getDate() {
        return date = dataEntrega == null ? "--/--/----" : dataEntrega.toString();
    }
}