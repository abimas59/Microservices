package io.github.abimas59.msavaliadorcredito.infra.clients;

import io.github.abimas59.msavaliadorcredito.domain.model.DadosCLiente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "msclientes", path = "/clientes")
public interface ClientResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<DadosCLiente> dadosCliente(@RequestParam("cpf") String cpf);
}
