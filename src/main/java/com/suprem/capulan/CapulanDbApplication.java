package com.suprem.capulan;

import com.suprem.capulan.model.produto.Produto;
import com.suprem.capulan.model.produto.Stock;
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
    private StockService service;


    @Override
    public void run(String... args) throws Exception {
        Stock stock = new Stock(100L, 9000L);
        Produto produto = new Produto("Adidas-Shorts-Capulan", 900);
        service.gravar(1, 1, 1, stock, produto);
    }


    public static void main(String[] args) {
        SpringApplication.run(CapulanDbApplication.class, args);
    }

}
