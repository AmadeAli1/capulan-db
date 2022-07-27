package com.suprem.capulan.service;

import com.suprem.capulan.model.produto.Produto;
import com.suprem.capulan.model.produto.Stock;
import com.suprem.capulan.model.produto.StockDto;
import com.suprem.capulan.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.suprem.capulan.service.UserService.INCREMENT;

@RequiredArgsConstructor
@Service
public class StockService implements CrudDatabase<Stock> {
    private final TerminalService terminalService;
    private final StockRepository stockRepository;
    private final FornecedorService fornecedorService;
    private final CategeoriaService categeoriaService;

    private final ProdutoService produtoService;

    public Boolean gravar(int idTerminal, int idFornecedor, int idCategoria, Stock stock, Produto produto) {
        var terminal = terminalService.findTerminal(idTerminal);
        var fornecedor = fornecedorService.findById(idFornecedor);
        var categoria = categeoriaService.findById(idCategoria);
        if (terminal.isPresent() && fornecedor.isPresent() && categoria.isPresent()) {
            stock.setIdFornecedor(fornecedor.get());
            stock.setDataChegada(LocalDate.now());
            stock.setId(STOCKMAXID() + INCREMENT);
            stock.setIdTerminal(terminal.get());
            Stock stock1 = stockRepository.save(stock);
            produto.setIdCategoria(categoria.get());
            produto.setIdStock(stock1);
            produto.setQuantidade(stock.getQuantidade());
            produtoService.save(produto);
            return true;
        } else {
            System.out.println("Impossivel gravar o stock, verifique os dados!!");
            return false;
        }
    }


    @Override
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    public List<StockDto> findAllStock() {
        System.out.println(findAll());
        return findAll().stream().map(StockDto::new).toList();
    }


    public Integer STOCKMAXID() {
        Integer maxid = stockRepository.MAXID();
        return maxid == null ? 0 : maxid;
    }

    @Override
    public Optional<Stock> findById(Integer id) {
        return stockRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        if (findById(id).isPresent()) {
            this.stockRepository.deleteById(id);
            System.out.println("Stock eliminado");
        } else {
            System.out.println("Stock not found!!");
        }
    }

}
