package br.com.mastertech.cartao.services;

import br.com.mastertech.cartao.client.ClienteClient;
import br.com.mastertech.cartao.dtos.Cliente;
import br.com.mastertech.cartao.exceptions.CartaoAlreadyExistsException;
import br.com.mastertech.cartao.exceptions.CartaoNotFoundException;
import br.com.mastertech.cartao.exceptions.ClienteNotValidException;
import br.com.mastertech.cartao.models.Cartao;
import br.com.mastertech.cartao.repositories.CartaoRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartaoService {

    @Autowired
    CartaoRepository cartaoRepository;

    @Autowired
    ClienteClient clienteClient;

    public Cartao create(Cartao cartao) {
        Optional<Cartao> findByNumero = cartaoRepository.findByNumero(cartao.getNumero());

        if (findByNumero.isPresent()) {
            throw new CartaoAlreadyExistsException();
        }

        clienteClient.getById(cartao.getClienteId());

        return cartaoRepository.save(cartao);
    }

    public Cartao get(String numero) {
        return getByNumero(numero);
    }

    public Cartao update(Cartao cartao) {
        Cartao cartaoUpdate = getByNumero(cartao.getNumero());

        cartaoUpdate.setAtivo(cartao.isAtivo());

        return cartaoRepository.save(cartaoUpdate);
    }

    public Cartao getByNumero(String numero) {
        Optional<Cartao> cartaoOptional = cartaoRepository.findByNumero(numero);

        if (!cartaoOptional.isPresent()) {
            throw new CartaoNotFoundException();
        }

        return cartaoOptional.get();
    }

    public Cartao getById(Integer id) {
        Optional<Cartao> cartaoOptional = cartaoRepository.findById(id);

        if (!cartaoOptional.isPresent()) {
            throw new CartaoNotFoundException();
        }

        return cartaoOptional.get();
    }
}
