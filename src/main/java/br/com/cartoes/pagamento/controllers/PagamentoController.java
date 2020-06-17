package br.com.cartoes.pagamento.controllers;

import br.com.cartoes.pagamento.dtos.PagamentoRequest;
import br.com.cartoes.pagamento.models.Pagamento;
import br.com.cartoes.pagamento.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pagamento create(@RequestBody @Validated PagamentoRequest pagamento) {
        return pagamentoService.create(pagamento);
    }

    @GetMapping("/{idCartao}")
    public List<Pagamento> getAllByCartao (@PathVariable Integer idCartao) {
        return pagamentoService.getAllByCartao(idCartao);
    }
}
