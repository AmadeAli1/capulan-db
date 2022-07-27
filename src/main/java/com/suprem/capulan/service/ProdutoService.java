package com.suprem.capulan.service;

import com.suprem.capulan.model.produto.Produto;
import com.suprem.capulan.model.produto.ProdutoDto;
import com.suprem.capulan.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.suprem.capulan.service.UserService.INCREMENT;

@RequiredArgsConstructor
@Service
public class ProdutoService implements CrudDatabase<Produto> {
    private final ProdutoRepository produtoRepository;

    public void save(Produto produto) {
        produto.setId(PRODUTOMAXID() + INCREMENT);
        this.produtoRepository.save(produto);
    }

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public List<ProdutoDto> findAllProdutos() {
        return produtoRepository.findAll().stream().map(ProdutoDto::new).toList();
    }

    public Integer PRODUTOMAXID() {
        Integer maxid = produtoRepository.MAXID();
        return maxid == null ? 0 : maxid;
    }

    @Override
    public Optional<Produto> findById(Integer id) {
        return produtoRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        if (findById(id).isPresent()) {
            this.produtoRepository.deleteById(id);
            System.out.println("Produto eliminado");
        } else {
            System.out.println("Produto not found!!");
        }
    }

}
