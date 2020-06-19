package br.com.mastertech.cartao.client;

import br.com.mastertech.cartao.dtos.Cliente;

import java.io.IOException;

public class ClienteClientFallback implements ClienteClient {
    private Exception cause;

    ClienteClientFallback(Exception cause) {
        this.cause = cause;
    }

    @Override
    public Cliente getById(Integer id) {
        if (cause instanceof IOException) {
            throw new RuntimeException("Serviço cliente fora do ar");
        }

        System.out.println(cause.getLocalizedMessage());
        System.out.println(cause.getClass().getName());
        System.out.println(cause.getCause());
        return new Cliente();
    }
}
