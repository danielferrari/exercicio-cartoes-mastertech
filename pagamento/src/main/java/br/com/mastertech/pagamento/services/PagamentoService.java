package br.com.mastertech.pagamento.services;

import br.com.mastertech.pagamento.client.CartaoClient;
import br.com.mastertech.pagamento.exceptions.CartaoNotValidException;
import br.com.mastertech.pagamento.models.Pagamento;
import br.com.mastertech.pagamento.repositories.PagamentoRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private CartaoClient cartaoClient;


    public Pagamento create(Pagamento pagamento) {
        try {
            cartaoClient.getByNumero(pagamento.getCartaoNumero());
        } catch(FeignException.NotFound ex) {
            throw new CartaoNotValidException();
        }

        return pagamentoRepository.save(pagamento);
    }

    public List<Pagamento> getAllByCartao(String cartaoNumero) {
        return pagamentoRepository.findByCartaoNumero(cartaoNumero);
    }
}
