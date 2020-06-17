package br.com.cartoes.cartao.repositories;

import br.com.cartoes.cartao.models.Cartao;
import org.springframework.data.repository.CrudRepository;

public interface CartaoRepository extends CrudRepository<Cartao, Integer> {
}
