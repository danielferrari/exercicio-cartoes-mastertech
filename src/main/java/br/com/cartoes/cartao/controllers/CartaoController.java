package br.com.cartoes.cartao.controllers;

import br.com.cartoes.cartao.dtos.CreateCartaoRequest;
import br.com.cartoes.cartao.dtos.UpdateCartaoRequest;
import br.com.cartoes.cartao.mappers.CartaoMapper;
import br.com.cartoes.cartao.models.Cartao;
import br.com.cartoes.cartao.services.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cartao")
public class CartaoController {
    @Autowired
    private CartaoService cartaoService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Cartao create(@RequestBody @Valid CreateCartaoRequest cartaoRequest) {
        Cartao cartao = CartaoMapper.fromCreateRequest(cartaoRequest);
        return cartaoService.create(cartao);
    }

    @GetMapping("/{id}")
    public Cartao get(@PathVariable Integer id) {
        return cartaoService.get(id);
    }

    @PatchMapping("/{id}")
    public Cartao update(@RequestBody @Valid UpdateCartaoRequest updateCartaoRequest, @PathVariable Integer id) {
        Cartao cartao = CartaoMapper.fromUpdateRequest(updateCartaoRequest);
        cartao.setId(id);

       return cartaoService.update(cartao);
    }
}
