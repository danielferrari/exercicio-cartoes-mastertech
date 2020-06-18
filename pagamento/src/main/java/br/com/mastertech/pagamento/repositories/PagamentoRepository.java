package br.com.mastertech.pagamento.repositories;

import br.com.mastertech.pagamento.models.Pagamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository extends CrudRepository<Pagamento, Integer> {
    List<Pagamento> findByCartaoNumero(String cartaoNumero);
}
