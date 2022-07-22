package com.suprem.capulan;

import com.suprem.capulan.model.produto.Stock;
import com.suprem.capulan.service.FornecedorService;
import com.suprem.capulan.service.StockService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class CapulanDbApplication implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
    }

    public static void main(String[] args) {
        SpringApplication.run(CapulanDbApplication.class, args);
    }

}
