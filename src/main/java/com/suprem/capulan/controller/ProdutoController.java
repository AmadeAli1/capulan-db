package com.suprem.capulan.controller;

import com.suprem.capulan.model.form.StockForm;
import com.suprem.capulan.model.produto.*;
import com.suprem.capulan.model.relationship.Encomenda;
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

    @PostMapping("/encomenda")
    public ResponseEntity<Boolean> save(
            @RequestBody Encomenda encomenda,
            @RequestParam("produto") Integer produto,
            @RequestParam("terminal") Integer terminal,
            @RequestParam("funcionario") Integer funcionario,
            @RequestParam("usuario") Integer usuario
    ) {
        var status = encomendaService.save(encomenda, produto, funcionario, usuario, terminal);
        return ResponseEntity.ok(status);
    }

    @GetMapping("/fornecedor")
    public List<FornecedorDto> findAllFornecedores() {
        return fornecedorService.findAllFornecedor();
    }

    @PostMapping("/fornecedor")
    public ResponseEntity<Boolean> save(@RequestBody Fornecedor fornecedor) {
        Boolean save = fornecedorService.save(fornecedor);
        return ResponseEntity.ok(save);
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
