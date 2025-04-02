package io.github.abimas59.msavaliadorcredito.application;

import io.github.abimas59.msavaliadorcredito.domain.model.CartaoCliente;
import io.github.abimas59.msavaliadorcredito.domain.model.DadosCLiente;
import io.github.abimas59.msavaliadorcredito.domain.model.SituacaoCliente;
import io.github.abimas59.msavaliadorcredito.infra.clients.CartoesResourceClient;
import io.github.abimas59.msavaliadorcredito.infra.clients.ClientResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    private final ClientResourceClient clientResourceClient;
    private final CartoesResourceClient cartoesResourceClient;


    public SituacaoCliente obterSituacaoCliente(String cpf){
        //obter dados / obter dados mscartoes
        ResponseEntity<DadosCLiente> dadosCLienteResponseEntity = clientResourceClient.dadosCliente(cpf);
        ResponseEntity<List<CartaoCliente>> cartoesByCliente = cartoesResourceClient.getCartoesByCliente(cpf);
        return SituacaoCliente
                .builder()
                .cliente(dadosCLienteResponseEntity.getBody())
                .cartoes(cartoesByCliente.getBody())
                .build();
    }

}
