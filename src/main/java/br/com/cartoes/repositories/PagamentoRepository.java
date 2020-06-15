package br.com.cartoes.repositories;

import br.com.cartoes.models.Pagamento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository extends CrudRepository<Pagamento, Integer> {
    @Query(value = "SELECT * FROM pagamento WHERE cartao_id = ?1", nativeQuery = true)
    List<Pagamento> findByCartaoId(Integer cartaoId);
}
