package com.suprem.capulan.model.produto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Getter
public class FornecedorDto implements Serializable {
    private Integer id;
    private String nomeEmpresa;
    private String contacto;
    private String email;

    public FornecedorDto(Fornecedor fornecedor) {
        this.id = fornecedor.getId();
        this.contacto = fornecedor.getContacto();
        this.nomeEmpresa = fornecedor.getNomeEmpresa();
        this.email = fornecedor.getEmail();
    }


}
