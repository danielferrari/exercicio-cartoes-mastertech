package br.com.cartoes.controllers;

import br.com.cartoes.dtos.CartaoAtivarDTO;
import br.com.cartoes.dtos.CartaoDTO;
import br.com.cartoes.models.Cartao;
import br.com.cartoes.services.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cartao")
public class CartaoController {
    @Autowired
    private CartaoService cartaoService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Cartao create(@RequestBody @Valid CartaoDTO cartao) {
        return cartaoService.create(cartao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cartao> get(@PathVariable Integer id) {
        return cartaoService.get(id)
                .map(cartao -> ResponseEntity.ok().body(cartao))
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cartao> enable(@RequestBody @Valid CartaoAtivarDTO cartaoAtivarDTO, @PathVariable Integer id) {
        return cartaoService.enable(cartaoAtivarDTO.getAtivar(), id)
                .map(cartao -> ResponseEntity.ok().body(cartao))
                .orElse(ResponseEntity.notFound().build());
    }
}
