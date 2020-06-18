package br.com.mastertech.pagamento.client;

import br.com.mastertech.pagamento.dtos.Cartao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cartao")
public interface CartaoClient {

    @GetMapping("/{numero}")
    Cartao getByNumero(@PathVariable String numero);
}
