package br.com.cartoes.pagamento.services;

import br.com.cartoes.pagamento.dtos.PagamentoRequest;
import br.com.cartoes.cartao.models.Cartao;
import br.com.cartoes.pagamento.exceptions.CartaoNotFoundException;
import br.com.cartoes.pagamento.models.Pagamento;
import br.com.cartoes.cartao.repositories.CartaoRepository;
import br.com.cartoes.pagamento.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private CartaoRepository cartaoRepository;


    public Pagamento create(PagamentoRequest pagamentoRequest) {
        Optional<Cartao> cartaoOptional = cartaoRepository.findById(pagamentoRequest.getCartaoId());

        if (!cartaoOptional.isPresent()) {
             throw new CartaoNotFoundException();
        }

        Pagamento pagamento = new Pagamento();
        pagamento.setCartao(cartaoOptional.get());
        pagamento.setDescricao(pagamentoRequest.getDescricao());
        pagamento.setValor(pagamentoRequest.getValor());

        return pagamentoRepository.save(pagamento);
    }

    public List<Pagamento> getAllByCartao(Integer cartaoId) {
        return pagamentoRepository.findByCartaoId(cartaoId);
    }
}
