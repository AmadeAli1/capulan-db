package com.suprem.capulan.controller;

import com.suprem.capulan.model.form.StockForm;
import com.suprem.capulan.model.produto.Categoria;
import com.suprem.capulan.model.produto.FornecedorDto;
import com.suprem.capulan.model.produto.ProdutoDto;
import com.suprem.capulan.model.produto.StockDto;
import com.suprem.capulan.model.views.Encomendaproduto;
import com.suprem.capulan.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/mz/produto")
public class ProdutoController {
    private final EncomendaService encomendaService;
    private final ProdutoService produtoService;
    private final FornecedorService fornecedorService;

    private final StockService stockService;
    private final CategeoriaService categeoriaService;

    @GetMapping
    public List<ProdutoDto> findAll() {
        return produtoService.findAllProdutos();
    }

    @GetMapping("/encomenda")
    public List<Encomendaproduto> findAllEncomendas() {
        return encomendaService.findAllEncomendas();
    }


    @GetMapping("/fornecedor")
    public List<FornecedorDto> findAllFornecedores() {
        return fornecedorService.findAllFornecedor();
    }

    @GetMapping("/categoria")
    public List<Categoria> findAllCategorias() {
        return categeoriaService.findAll();
    }

    @GetMapping("/stock")
    public List<StockDto> findAllStock() {
        return stockService.findAllStock();
    }

    @PostMapping("/save")
    public ResponseEntity<Boolean> save(
            @RequestBody StockForm stock,
            @RequestParam("location") Integer location,
            @RequestParam("categoria") Integer categoria,
            @RequestParam("fornecedor") Integer fornecedor
    ) {
        Boolean gravar = stockService.gravar(location, fornecedor, categoria, stock.getStock(), stock.getProduto());
        return ResponseEntity.ok(gravar);
    }

}
