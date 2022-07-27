package com.suprem.capulan.controller;

import com.suprem.capulan.model.produto.FornecedorDto;
import com.suprem.capulan.model.produto.ProdutoDto;
import com.suprem.capulan.model.views.Encomendaproduto;
import com.suprem.capulan.service.EncomendaService;
import com.suprem.capulan.service.FornecedorService;
import com.suprem.capulan.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/mz/produto")
public class ProdutoController {
    private final EncomendaService encomendaService;
    private final ProdutoService produtoService;
    private final FornecedorService fornecedorService;

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


}
