package com.suprem.capulan.service;

import com.suprem.capulan.model.location.Terminal;
import com.suprem.capulan.model.produto.Fornecedor;
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

        Optional<Terminal> terminal = terminalService.findTerminal(idTerminal);
        Optional<Fornecedor> fornecedor = fornecedorService.findOne(
                idFornecedor
        );

        if (terminal.isPresent() && fornecedor.isPresent()) {
            //stock.setFo(fornecedor.get());
            //stock.setIdTerminal();
            //stockRepository.save(stock);
        }

    }

    @Override
    public List<Stock> findAll() {
        return null;
    }

    @Override
    public Optional<Stock> findOne(Integer id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Integer id) {

    }

}
