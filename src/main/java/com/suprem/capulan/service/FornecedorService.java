package com.suprem.capulan.service;

import com.suprem.capulan.model.produto.Fornecedor;
import com.suprem.capulan.model.produto.FornecedorDto;
import com.suprem.capulan.repository.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.suprem.capulan.service.UserService.INCREMENT;

@RequiredArgsConstructor
@Service
public class FornecedorService implements CrudDatabase<Fornecedor> {
    private final FornecedorRepository fornecedorRepository;

    public void save(Fornecedor fornecedor) {
        if (fornecedor == null) {
            System.out.println("Fornecedor must not be null!");
        } else {
            fornecedor.setId(FORNECEDORMAXID() + INCREMENT);
            this.fornecedorRepository.save(fornecedor);
        }
    }


    public Integer FORNECEDORMAXID() {
        Integer maxid = fornecedorRepository.MAXID();
        return maxid == null ? 0 : maxid;
    }

    @Override
    public List<Fornecedor> findAll() {
        return fornecedorRepository.findAll();
    }

    public List<FornecedorDto> findAllFornecedor() {
        return findAll().stream().map(FornecedorDto::new).toList();
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
