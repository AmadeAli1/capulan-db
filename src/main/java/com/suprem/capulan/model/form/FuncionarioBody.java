package com.suprem.capulan.model.form;

import com.suprem.capulan.model.user.Funcionario;
import com.suprem.capulan.model.user.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioBody {
    private Usuario user;
    private Funcionario empregado;
}
