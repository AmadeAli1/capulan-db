package com.suprem.capulan.service;

import com.suprem.capulan.exception.Message;
import com.suprem.capulan.model.user.Cliente;
import com.suprem.capulan.model.user.Funcionario;
import com.suprem.capulan.model.user.Usuario;
import com.suprem.capulan.repository.ClienteRepository;
import com.suprem.capulan.repository.FuncionarioRepository;
import com.suprem.capulan.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UsuarioRepository usuarioRepository;
    private final ClienteRepository clienteRepository;
    private final FuncionarioRepository funcionarioRepository;

    public Object gravarCliente(Usuario usuario, Cliente cliente) {
        if (verificarEmail(cliente.getEmail())) {
            return new Message("email", "Email already exist");
        }
        if (verificarbi(usuario.getBi())) {
            return new Message("bi", "Bi already exist");
        }
        Usuario usuarioSaved = usuarioRepository.save(usuario);
        cliente.setIdUsuario(usuarioSaved);
        return clienteRepository.save(cliente);
    }


    public Object gravarFuncionario(Usuario usuario, Funcionario funcionario) {
        if (verificarbi(usuario.getBi())) {
            return new Message("bi", "Bi already exist");
        }
        Usuario usuarioSaved = usuarioRepository.save(usuario);
        funcionario.setIdUsuario(usuarioSaved);
        return funcionarioRepository.save(funcionario);
    }


    private Boolean verificarEmail(String email) {
        return clienteRepository.findByEmail(email).isPresent();
    }

    private Boolean verificarbi(String bi) {
        return usuarioRepository.findByBi(bi).isPresent();
    }

}
