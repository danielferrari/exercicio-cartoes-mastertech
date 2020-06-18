package br.com.mastertech.cartao.controllers;

import br.com.mastertech.cartao.dtos.CreateCartaoRequest;
import br.com.mastertech.cartao.dtos.UpdateCartaoRequest;
import br.com.mastertech.cartao.mappers.CartaoMapper;
import br.com.mastertech.cartao.models.Cartao;
import br.com.mastertech.cartao.services.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
public class CartaoController {
    @Autowired
    private CartaoService cartaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cartao create(@RequestBody @Valid CreateCartaoRequest cartaoRequest) {
        Cartao cartao = CartaoMapper.fromCreateRequest(cartaoRequest);
        return cartaoService.create(cartao);
    }

    @GetMapping("/{numero}")
    public Cartao get(@PathVariable String numero) {
        return cartaoService.get(numero);
    }

    @PatchMapping("/{numero}")
    public Cartao update(@RequestBody @Valid UpdateCartaoRequest updateCartaoRequest, @PathVariable String numero) {
        Cartao cartao = CartaoMapper.fromUpdateRequest(updateCartaoRequest);
        cartao.setNumero(numero);

       return cartaoService.update(cartao);
    }
}
