package com.suprem.capulan.service;

import com.suprem.capulan.model.produto.Stock;
import com.suprem.capulan.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StockService implements CrudDatabase<Stock> {
    private final TerminalService terminalService;
    private final StockRepository stockRepository;
    private final FornecedorService fornecedorService;


    public void gravar(int idTerminal, int idFornecedor, Stock stock) {
        var terminal = terminalService.findTerminal(idTerminal);
        var fornecedor = fornecedorService.findById(idFornecedor);
        if (terminal.isPresent() && fornecedor.isPresent()) {
            stock.setIdFornecedor(fornecedor.get());
            stock.setIdTerminal(terminal.get());
            stockRepository.save(stock);
        } else {
            System.out.println("Impossivel gravar o stock, verifique os dados!!");
        }
    }

    @Override
    public List<Stock> findAll() {
        return stockRepository.findAll();
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
