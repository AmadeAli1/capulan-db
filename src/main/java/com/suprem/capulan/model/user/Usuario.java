package com.suprem.capulan.model.user;

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
    private Integer id;

    @Column(name = "NOME", nullable = false, length = 50)
    private String nome;

    @Column(name = "BI", nullable = false, length = 13)
    private String bi;

    @Enumerated(EnumType.STRING)
    @Column(name = "SEXO", length = 10)
    private Genre genre;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO", nullable = false, length = 15)
    private UserType tipo;

    @Column(name = "SENHA", nullable = false, length = 50)
    private String senha;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_TERMINAL", nullable = false)
    private Terminal idTerminal;

    public Usuario(String nome, String bi, Genre genre, UserType tipo, String senha, Terminal idTerminal) {
        this.nome = nome;
        this.bi = bi;
        this.genre = genre;
        this.tipo = tipo;
        this.senha = senha;
        this.idTerminal = idTerminal;
    }
}