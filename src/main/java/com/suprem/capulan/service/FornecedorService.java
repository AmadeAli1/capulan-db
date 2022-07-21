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
        //fornecedorRepository.save(fornecedor);
    }

    @Override
    public List<Fornecedor> findAll() {
        return null;
    }

    @Override
    public Optional<Fornecedor> findOne(Integer id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Integer id) {

    }

}
