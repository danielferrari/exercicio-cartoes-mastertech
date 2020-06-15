package br.com.cartoes.repositories;

import br.com.cartoes.models.Cartao;
import org.springframework.data.repository.CrudRepository;

public interface CartaoRepository extends CrudRepository<Cartao, Integer> {
}
