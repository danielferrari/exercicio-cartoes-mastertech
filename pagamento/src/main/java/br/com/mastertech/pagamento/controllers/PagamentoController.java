package br.com.mastertech.pagamento.controllers;

import br.com.mastertech.pagamento.dtos.CreatePagamentoRequest;
import br.com.mastertech.pagamento.mappers.PagamentoMapper;
import br.com.mastertech.pagamento.models.Pagamento;
import br.com.mastertech.pagamento.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pagamento create(@RequestBody @Validated CreatePagamentoRequest pagamentoRequest) {
        Pagamento pagamento = PagamentoMapper.fromCreateRequest(pagamentoRequest);
        return pagamentoService.create(pagamento);
    }

    @GetMapping("/{numero}")
    public List<Pagamento> getAllByCartao (@PathVariable String numero) {
        return pagamentoService.getAllByCartao(numero);
    }
}
