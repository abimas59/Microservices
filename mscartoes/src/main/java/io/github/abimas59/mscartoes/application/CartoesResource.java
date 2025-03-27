package io.github.abimas59.mscartoes.application;

import io.github.abimas59.mscartoes.domain.Cartao;
import io.github.abimas59.mscartoes.domain.ClienteCartao;
import io.github.abimas59.mscartoes.representation.CartaoSaveRequest;
import io.github.abimas59.mscartoes.representation.CartoesPorClienteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("cartoes")
@RestController
@RequiredArgsConstructor
public class CartoesResource {


    private final CartaoService cartaoService;
    private final ClienteCartaoService clienteCartaoService;

    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CartaoSaveRequest request){
        Cartao cartao = request.toModel();
        cartaoService.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartoesRendaAte(@RequestParam("renda") Long renda){
        List<Cartao> list = cartaoService.getCartoesRendaMenorIgual(renda);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesPorClienteResponse>> getCartoesByCliente(@RequestParam("cpf") String cpf){
        List<ClienteCartao> clienteCartaos = clienteCartaoService.listCartoesByCpf(cpf);
        List<CartoesPorClienteResponse> responseList = clienteCartaos.stream().map(CartoesPorClienteResponse::fromModel).collect(Collectors.toList());
        return ResponseEntity.ok(responseList);
    }
}
