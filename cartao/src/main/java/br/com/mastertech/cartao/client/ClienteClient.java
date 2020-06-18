package br.com.mastertech.cartao.client;

import br.com.mastertech.cartao.dtos.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cliente")
public interface ClienteClient {

    @GetMapping("/{id}")
    Cliente getById(@PathVariable Integer id);
}
