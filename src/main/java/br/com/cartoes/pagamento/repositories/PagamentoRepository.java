package br.com.cartoes.pagamento.repositories;

import br.com.cartoes.pagamento.models.Pagamento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository extends CrudRepository<Pagamento, Integer> {
    List<Pagamento> findByCartaoId(Integer cartaoId);
}
