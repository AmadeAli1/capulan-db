package com.suprem.capulan.controller;

import com.suprem.capulan.model.views.Encomendaproduto;
import com.suprem.capulan.service.EncomendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/mz/encomenda")
@RestController
public class EncomendaController {
    private final EncomendaService service;

    @GetMapping
    public List<Encomendaproduto> findAll() {
        return service.findAllEncomendas();
    }


}
