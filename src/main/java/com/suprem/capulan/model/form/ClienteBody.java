package com.suprem.capulan.model.form;

import com.suprem.capulan.model.user.Cliente;
import com.suprem.capulan.model.user.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteBody {
    private Cliente cliente;
    private Usuario user;

    public ClienteBody(Cliente cliente, Usuario user) {
        this.cliente = cliente;
        this.user = user;
    }
    
}
