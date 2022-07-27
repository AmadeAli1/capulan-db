package com.suprem.capulan;

import com.suprem.capulan.service.EncomendaService;
import com.suprem.capulan.service.FornecedorService;
import com.suprem.capulan.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class CapulanDbApplication implements CommandLineRunner {
    @Autowired
    private EncomendaService service;
    @Autowired
    private StockService stockService;

    @Autowired
    private FornecedorService fornecedorService;

    public static void main(String[] args) {
        SpringApplication.run(CapulanDbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        fornecedorService.save(new Fornecedor("Jose-Corp","+125888957852","ali@gmail.com"));
//
//        Stock stock = new Stock(1000L, 200000L);
//        Produto produto = new Produto("Calsas-AlyCap", 3000);
//        stockService.gravar(1, 1, 1, stock, produto);
//
//        Encomenda encomenda = new Encomenda(7L);
//        encomenda.setDataEntrega(LocalDate.now().plus(10, ChronoUnit.DAYS));
//        service.save(encomenda, 1, 1, 1, 1);

    }

}
