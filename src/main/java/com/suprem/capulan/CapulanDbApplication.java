package com.suprem.capulan;

import com.suprem.capulan.model.user.Cliente;
import com.suprem.capulan.model.user.Genre;
import com.suprem.capulan.model.user.UserType;
import com.suprem.capulan.model.user.Usuario;
import com.suprem.capulan.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class CapulanDbApplication implements CommandLineRunner {
    @Autowired
    private UserService service;


    @Override
    public void run(String... args) throws Exception {

        //var usuario = new Usuario("Marques JR", "1212121212fid", Genre.MASCULINO, UserType.CLIENTE, "senha123333");
        //var cliente = new Cliente("marques123jr@gmail.com", "123wqrs", "Benfica");

        //service.gravarCliente(usuario,cliente,4);

    }


    public static void main(String[] args) {
        SpringApplication.run(CapulanDbApplication.class, args);
    }

}
