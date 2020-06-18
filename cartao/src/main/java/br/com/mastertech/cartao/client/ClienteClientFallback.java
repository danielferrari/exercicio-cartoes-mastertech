package br.com.mastertech.cartao.client;

import br.com.mastertech.cartao.dtos.Cliente;

public class ClienteClientFallback implements ClienteClient {
    private Exception cause;

    ClienteClientFallback(Exception cause) {
        this.cause = cause;
    }

    @Override
    public Cliente getById(Integer id) {
        return new Cliente();
    }
}
