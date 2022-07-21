package com.suprem.capulan;

import com.suprem.capulan.model.produto.Categoria;
import com.suprem.capulan.service.CatgeoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CapulanDbApplication implements CommandLineRunner {
    @Autowired
    private CatgeoriaService catgeoriaService;


    @Override
    public void run(String... args) throws Exception {

        Categoria pablo_style = new Categoria("Pablo", "Hoodeis");
        catgeoriaService.gravarCategoria(pablo_style);

        catgeoriaService.delete(2);

        System.out.println(catgeoriaService.findAll());

    }

    public static void main(String[] args) {
        SpringApplication.run(CapulanDbApplication.class, args);
    }

}
