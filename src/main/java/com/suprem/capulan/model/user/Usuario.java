package com.suprem.capulan.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.suprem.capulan.model.location.Terminal;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @Column(name = "ID_USUARIO", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_ID")
    @SequenceGenerator(name = "USUARIO_ID", sequenceName = "USUARIO_ID", allocationSize = 1)
    private Integer id;

    @Column(name = "NOME", nullable = false, length = 50)
    private String nome;

    @Column(name = "BI", nullable = false, length = 13)
    private String bi;

    @Enumerated(EnumType.STRING)
    @Column(name = "SEXO", length = 10)
    private Genre sexo;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO", nullable = false, length = 15)
    private UserType userType;

    @Column(name = "SENHA", nullable = false, length = 50)
    private String senha;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_TERMINAL", nullable = false)
    private Terminal idTerminal;

    public Usuario(String nome, String bi, Genre sexo, UserType userType, String senha) {
        this.nome = nome;
        this.bi = bi;
        this.sexo = sexo;
        this.userType = userType;
        this.senha = senha;
    }
}