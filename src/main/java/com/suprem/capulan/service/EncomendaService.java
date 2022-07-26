package com.suprem.capulan.service;

import com.suprem.capulan.model.relationship.Encomenda;
import com.suprem.capulan.model.relationship.FuncionarioEncomenda;
import com.suprem.capulan.repository.EncomendaRepository;
import com.suprem.capulan.repository.FuncionarioEncomendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static com.suprem.capulan.service.UserService.INCREMENT;

@RequiredArgsConstructor
@Service
public class EncomendaService implements CrudDatabase<Encomenda> {
    private final EncomendaRepository repository;
    private final ProdutoService produtoService;
    private final UserService userService;

    private final FuncionarioEncomendaRepository funcionarioEncomendaRepository;
    private final TerminalService terminalService;

    @Transactional
    public void save(Encomenda encomenda, int idProduto, int idFuncionario, int idUsuario, int idTerminal) {
        var funcionario = userService.findFuncionarioById(idFuncionario);
        var produto = produtoService.findById(idProduto);
        var usuario = userService.findById(idUsuario);
        var terminal = terminalService.findTerminal(idTerminal);
        if (funcionario.isPresent() && produto.isPresent() && usuario.isPresent() && terminal.isPresent()) {
            long precoTotal = encomenda.getQuantidade() * produto.get().getPreco();
            encomenda.setPreco(precoTotal);
            encomenda.setId(ENCOMENDAMAXID() + INCREMENT);
            encomenda.setProduto(produto.get());
            encomenda.setTerminal(terminal.get());
            encomenda.setUsuario(usuario.get());
            Encomenda save1 = repository.save(encomenda);
            var funcionarioEncomenda = new FuncionarioEncomenda(funcionario.get(), save1);
            funcionarioEncomenda.setId(FUNCIONARIO_ENCOMENDA_MAXID() + INCREMENT);
            this.funcionarioEncomendaRepository.save(funcionarioEncomenda);
        } else {
            System.out.println("Erro ao gravar a encomenda");
        }
    }


    public Integer ENCOMENDAMAXID() {
        Integer maxid = repository.MAXID();
        return maxid == null ? 0 : maxid;
    }


    public Integer FUNCIONARIO_ENCOMENDA_MAXID() {
        Integer maxid = funcionarioEncomendaRepository.MAXID();
        return maxid == null ? 0 : maxid;
    }

    @Override
    public List<Encomenda> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Encomenda> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        if (findById(id).isPresent()) {
            this.repository.deleteById(id);
            System.out.println("Encomenda eliminada");
        } else {
            System.out.println("Encomenda not found!!");
        }
    }
}
