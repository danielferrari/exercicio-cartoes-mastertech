package br.com.cartoes.cliente.services;

import br.com.cartoes.cliente.models.Cliente;
import br.com.cartoes.cliente.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clientRepository;

    public Cliente create(Cliente cliente) {
        return clientRepository.save(cliente);
    }

    public Optional<Cliente> get(Integer id) {
        return clientRepository.findById(id);
    }
}
