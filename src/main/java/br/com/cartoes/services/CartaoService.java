package br.com.cartoes.services;

import br.com.cartoes.dtos.CartaoDTO;
import br.com.cartoes.models.Cartao;
import br.com.cartoes.models.Cliente;
import br.com.cartoes.repositories.CartaoRepository;
import br.com.cartoes.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.Optional;

@Service
public class CartaoService {

    @Autowired
    CartaoRepository cartaoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public Cartao create(CartaoDTO cartaoDTO) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(cartaoDTO.getClienteId());

        if (!clienteOptional.isPresent()) {
            throw new RuntimeException("Cliente não encontrado");
        }

        Cartao cartao = new Cartao();
        cartao.setCliente(clienteOptional.get());
        cartao.setNumero(cartaoDTO.getNumero());
        return cartaoRepository.save(cartao);
    }

    public Optional<Cartao> get(Integer id) {
        return cartaoRepository.findById(id);
    }

    public Optional<Cartao> enable(boolean enable, Integer id) {
        return cartaoRepository.findById(id).map(
                cartao -> {
                    cartao.setAtivo(enable);
                    return cartaoRepository.save(cartao);
                }
        );
    }
}
