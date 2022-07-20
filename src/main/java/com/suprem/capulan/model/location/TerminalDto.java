package com.suprem.capulan.model.location;

import lombok.Getter;

import java.io.Serializable;


@Getter
public class TerminalDto implements Serializable {
    private final Integer id;
    private final String nome;
    private final Region region;

    public TerminalDto(Terminal terminal) {
        this.id = terminal.getId();
        this.nome = terminal.getNome();
        this.region = terminal.getRegion();
    }

}
