package com.suprem.capulan.service;

import com.suprem.capulan.model.produto.Fornecedor;
import com.suprem.capulan.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FornecedorService implements CrudDatabase<Fornecedor> {
    private final FornecedorRepository fornecedorRepository;

    public void save(Fornecedor fornecedor) {
        if (fornecedor == null) {
            System.out.println("Fornecedor must not be null!");
        } else {
            this.fornecedorRepository.save(fornecedor);
        }
    }

    @Override
    public List<Fornecedor> findAll() {
        return fornecedorRepository.findAll();
    }

    @Override
    public Optional<Fornecedor> findById(Integer id) {
        return fornecedorRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        if (findById(id).isPresent()) {
            this.fornecedorRepository.deleteById(id);
            System.out.println("Fornecedor eliminado");
        } else {
            System.out.println("Fornecedor not found!!");
        }
    }

}
