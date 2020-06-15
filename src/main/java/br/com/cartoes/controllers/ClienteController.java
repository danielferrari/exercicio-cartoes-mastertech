package br.com.cartoes.controllers;

import br.com.cartoes.models.Cliente;
import br.com.cartoes.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody @Valid Cliente cliente) {
        return clienteService.create(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable Integer id) {
        return clienteService.get(id)
                .map(cliente -> ResponseEntity.ok().body(cliente))
                .orElse(ResponseEntity.notFound().build());
    }
}
