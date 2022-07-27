package com.suprem.capulan.model.produto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StockDto implements Serializable {
    private Integer id;
    private Long quantidade;
    private String dataChegada;
    private Long preco;
    private Integer fornecedor;


    public StockDto(Stock stock) {
        this.id = stock.getId();
        this.quantidade = stock.getQuantidade();
        this.dataChegada = stock.getDataChegada().toString();
        this.preco = stock.getPreco();
        this.fornecedor = stock.getIdFornecedor().getId();
    }

}
