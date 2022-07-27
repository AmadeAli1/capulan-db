package com.suprem.capulan.model.form;

import com.suprem.capulan.model.produto.Produto;
import com.suprem.capulan.model.produto.Stock;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockForm {
    private Stock stock;
    private Produto produto;
}
