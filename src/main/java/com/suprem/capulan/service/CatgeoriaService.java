package com.suprem.capulan.service;


import com.suprem.capulan.model.produto.Categoria;
import com.suprem.capulan.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatgeoriaService {
    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CatgeoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public void gravarCategoria(Categoria categoria) {
        if (categoria != null) {
            Categoria save = this.categoriaRepository.save(categoria);
            System.out.println("Categoria Gravado com sucesso");
            System.out.println(save);
        } else {
            System.out.println("A categoria nao pode ser nulo");
        }
    }

    public void delete(Integer id) {
        Optional<Categoria> categoria = findById(id);
        if (categoria.isPresent()) {
            categoriaRepository.deleteById(id);

            System.out.println("Categoria Removida:: !" + categoria.get());
        } else {
            System.out.println("Impossivel remover algo que nao existe!");
        }
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }


    public Optional<Categoria> findById(Integer id) {
        return categoriaRepository.findById(id);
    }


}
