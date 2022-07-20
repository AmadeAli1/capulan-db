package com.suprem.capulan;

import com.suprem.capulan.model.location.Region;
import com.suprem.capulan.repository.TerminalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CapulanDbApplication implements CommandLineRunner {
    @Autowired
    TerminalRepository terminalRepository;

    @Override
    public void run(String... args) throws Exception {

    }

    public static void main(String[] args) {
        SpringApplication.run(CapulanDbApplication.class, args);
    }

}
