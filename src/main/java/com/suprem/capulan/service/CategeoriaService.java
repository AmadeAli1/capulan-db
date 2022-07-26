package com.suprem.capulan.service;


import com.suprem.capulan.model.produto.Categoria;
import com.suprem.capulan.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategeoriaService implements CrudDatabase<Categoria> {
    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategeoriaService(CategoriaRepository categoriaRepository) {
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


    @Override
    public void deleteById(Integer id) {
        Optional<Categoria> categoria = findById(id);
        if (categoria.isPresent()) {
            categoriaRepository.deleteById(id);

            System.out.println("Categoria Removida:: !" + categoria.get());
        } else {
            System.out.println("Impossivel remover algo que nao existe!");
        }
    }

    @Override
    public List<Categoria> findAll() {
        System.out.println("HERE");
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> findById(Integer id) {
        return categoriaRepository.findById(id);
    }


}
