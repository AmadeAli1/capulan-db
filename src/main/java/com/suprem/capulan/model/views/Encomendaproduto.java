package com.suprem.capulan.model.views;

import lombok.Getter;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Mapping for DB view
 */
@Getter
@Entity
@Immutable
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

    @Column(name = "ESTADO", nullable = false, length = 50)
    private String estado;

    @Column(name = "NOME", nullable = false, length = 50)
    private String nome;

    @Column(name = "CLIENTE", nullable = false, length = 50)
    private String cliente;

    @Transient
    private String date = dataEntrega.toString();
}