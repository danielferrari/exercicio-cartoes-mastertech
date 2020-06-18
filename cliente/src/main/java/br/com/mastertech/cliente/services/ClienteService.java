package br.com.mastertech.cliente.services;

import br.com.mastertech.cliente.exceptions.ClienteNotFoundException;
import br.com.mastertech.cliente.models.Cliente;
import br.com.mastertech.cliente.repositories.ClienteRepository;
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

    public Cliente get(Integer id) {
        Optional<Cliente> clienteOptional = clientRepository.findById(id);

        if (!clienteOptional.isPresent()) {
            throw new ClienteNotFoundException();
        }

        return clienteOptional.get();
    }
}
