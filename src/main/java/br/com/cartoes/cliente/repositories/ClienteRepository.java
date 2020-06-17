package br.com.cartoes.cliente.repositories;

import br.com.cartoes.cliente.models.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
}
