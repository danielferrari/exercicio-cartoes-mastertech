package br.com.cartoes.cartao.services;

import br.com.cartoes.cartao.exceptions.CartaoNotFoundException;
import br.com.cartoes.cartao.exceptions.ClienteNotFoundException;
import br.com.cartoes.cartao.models.Cartao;
import br.com.cartoes.cartao.repositories.CartaoRepository;
import br.com.cartoes.cliente.models.Cliente;
import br.com.cartoes.cliente.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartaoService {

    @Autowired
    CartaoRepository cartaoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public Cartao create(Cartao cartao) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(cartao.getId());

        if (!clienteOptional.isPresent()) {
            throw new ClienteNotFoundException();
        }

        return cartaoRepository.save(cartao);
    }

    public Cartao get(Integer id) {
        Optional<Cartao> cartaoOptional = cartaoRepository.findById(id);

        if (!cartaoOptional.isPresent()) {
            throw new CartaoNotFoundException();
        }

        return cartaoOptional.get();
    }

    public Cartao update(Cartao cartao) {
        Optional<Cartao> cartaoOptional = cartaoRepository.findById(cartao.getId());

        if (!cartaoOptional.isPresent()) {
            throw new CartaoNotFoundException();
        }

        return cartaoOptional.get();
    }
}
