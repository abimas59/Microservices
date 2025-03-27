package io.github.abimas59.msclientes.application.representation;

import io.github.abimas59.msclientes.domain.Cliente;
import lombok.Data;

@Data
public class ClienteSaveRequest {
    private String cpf;
    private String nome;
    private Integer idade;

    public Cliente toModel(){
        return new Cliente(cpf,nome,idade);
    }
}
