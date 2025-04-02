package io.github.abimas59.msavaliadorcredito.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SituacaoCliente {

    private DadosCLiente cliente;
    private List<CartaoCliente> cartoes;
}
