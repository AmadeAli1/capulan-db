package com.suprem.capulan.model.produto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class ProdutoDto implements Serializable {
    private final Integer id;
    private final String nome;
    private final long preco;
    private final Long quantidade;
    private final CategoriaType categoriaType;

    public ProdutoDto(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.quantidade = produto.getQuantidade();
        this.categoriaType = produto.getIdCategoria().getCategoriaType();
    }

}
