package br.com.cartoes.controllers;

import br.com.cartoes.dtos.PagamentoDTO;
import br.com.cartoes.models.Pagamento;
import br.com.cartoes.services.PagamentoService;
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
    public Pagamento create(@RequestBody @Validated PagamentoDTO pagamento) {
        return pagamentoService.create(pagamento);
    }

    @GetMapping("/{idCartao}")
    public List<Pagamento> getAllByCartao (@PathVariable Integer idCartao) {
        return pagamentoService.getAllByCartao(idCartao);
    }
}
