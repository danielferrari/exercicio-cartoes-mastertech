package br.com.mastertech.cartao.repositories;

import br.com.mastertech.cartao.models.Cartao;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartaoRepository extends CrudRepository<Cartao, Integer> {
    Optional<Cartao> findByNumero(String numero);
}
