package com.suprem.capulan.service;

import com.suprem.capulan.exception.Message;
import com.suprem.capulan.model.location.Terminal;
import com.suprem.capulan.model.user.*;
import com.suprem.capulan.repository.ClienteRepository;
import com.suprem.capulan.repository.FuncionarioRepository;
import com.suprem.capulan.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UsuarioRepository usuarioRepository;
    private final ClienteRepository clienteRepository;
    private final FuncionarioRepository funcionarioRepository;

    private final TerminalService terminalService;

    public ResponseEntity<Object> gravarCliente(Usuario usuario, Cliente cliente, Integer location) {
        if (verificarEmail(cliente.getEmail())) {
            return ResponseEntity.badRequest().body(new Message("email", "Email already exist"));
        }
        if (verificarbi(usuario.getBi())) {
            return ResponseEntity.badRequest().body(new Message("bi", "Bi already exist"));
        }
        Optional<Terminal> terminal = terminalService.findTerminal(location);
        Usuario usuarioSaved = null;
        try {
            usuario.setIdTerminal(terminal.get());
            usuarioSaved = usuarioRepository.save(usuario);
            cliente.setIdUsuario(usuarioSaved);
            Cliente save = clienteRepository.save(cliente);
            Optional<Usercliente> clienteById = usuarioRepository.findClienteById(save.getId());
            return new ResponseEntity<>(clienteById.get(), HttpStatus.CREATED);
        } catch (Exception e) {
            if (usuarioSaved != null) {
                usuarioRepository.delete(usuario);
            }
            return ResponseEntity.badRequest().body(new Message("exception", e.getMessage()));
        }
    }


    public ResponseEntity<Object> gravarFuncionario(Usuario usuario, Funcionario funcionario, Integer location) {
        if (verificarbi(usuario.getBi())) {
            return ResponseEntity.badRequest().body(new Message("bi", "Bi already exist"));
        }
        Optional<Terminal> terminal = terminalService.findTerminal(location);
        Usuario usuarioSaved = null;
        try {
            usuario.setIdTerminal(terminal.get());
            usuarioSaved = usuarioRepository.save(usuario);
            funcionario.setIdUsuario(usuarioSaved);
            Funcionario save = funcionarioRepository.save(funcionario);
            Optional<Userfuncionario> funcionarioById = usuarioRepository.findFuncionarioById(save.getId());
            return new ResponseEntity<>(funcionarioById.get(), HttpStatus.CREATED);
        } catch (Exception e) {
            if (usuarioSaved != null) {
                usuarioRepository.delete(usuario);
            }
            return ResponseEntity.badRequest().body(new Message("exception", e.getMessage()));
        }
    }

    public ResponseEntity<Object> login(Integer codigo, String senha) {
        var funcionario = usuarioRepository.findFuncionarioById(codigo);
        if (funcionario.isEmpty()) {
            return ResponseEntity.badRequest().body(new Message("codigo", "User not found"));
        } else if (funcionario.get().getSenha().equals(senha)) {
            return ResponseEntity.ok(funcionario.get());
        }
        return ResponseEntity.badRequest().body(new Message("senha", "Senha Invalida"));
    }

    public List<Usercliente> findAllClientes() {
        return usuarioRepository.findAllCliente();
    }

    public List<Userfuncionario> findAllFuncionarios() {
        return usuarioRepository.findAllFuncionario();
    }

    private Boolean verificarEmail(String email) {
        return clienteRepository.findByEmail(email).isPresent();
    }

    private Boolean verificarbi(String bi) {
        return usuarioRepository.findByBi(bi).isPresent();
    }

    public ResponseEntity<Boolean> deleteById(Integer id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.badRequest().body(false);
    }
}
