package br.com.mastertech.cliente.controllers;

import br.com.mastertech.cliente.models.Cliente;
import br.com.mastertech.cliente.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody @Valid Cliente cliente) {
        return clienteService.create(cliente);
    }

    @GetMapping("/{id}")
    public Cliente get(@PathVariable Integer id) {
        return clienteService.get(id);
    }
}
