package com.suprem.capulan.controller;

import com.suprem.capulan.model.form.ClienteBody;
import com.suprem.capulan.model.form.FuncionarioBody;
import com.suprem.capulan.model.user.Usercliente;
import com.suprem.capulan.model.user.Userfuncionario;
import com.suprem.capulan.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/mz/user")
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/cliente")
    public ResponseEntity<Object> registrarCliente(
            @RequestParam("location") Integer location,
            @RequestBody ClienteBody clienteBody
    ) {
        return userService.gravarCliente(clienteBody.getUser(), clienteBody.getCliente(), location);
    }

    @PostMapping("/empregado")
    public ResponseEntity<Object> registrarCliente(
            @RequestParam("location") Integer location,
            @RequestBody FuncionarioBody empregadoBody
    ) {
        return userService.gravarFuncionario(empregadoBody.getUser(), empregadoBody.getEmpregado(), location);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteById(@RequestParam("id") Integer idUser) {
        ResponseEntity<Boolean> booleanResponseEntity = userService.deleteById(idUser);
        System.out.println(booleanResponseEntity.getBody());
        return booleanResponseEntity;
    }

    @GetMapping("/login/work")
    public ResponseEntity<Object> login(
            @RequestParam("codigo") Integer id,
            @RequestParam("senha") String senha
    ) {
        return userService.login(id, senha);
    }

    @GetMapping("/cliente")
    public List<Usercliente> findAllClientes() {
        return userService.findAllClientes();
    }

    @GetMapping("/empregado")
    public List<Userfuncionario> findAllEmpregados() {
        return userService.findAllFuncionarios();
    }
}
