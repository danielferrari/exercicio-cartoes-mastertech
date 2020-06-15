package br.com.cartoes.services;

import br.com.cartoes.dtos.PagamentoDTO;
import br.com.cartoes.models.Cartao;
import br.com.cartoes.models.Pagamento;
import br.com.cartoes.repositories.CartaoRepository;
import br.com.cartoes.repositories.PagamentoRepository;
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


    public Pagamento create(PagamentoDTO pagamentoDTO) {
        Optional<Cartao> cartaoOptional = cartaoRepository.findById(pagamentoDTO.getCartaoId());

        if (!cartaoOptional.isPresent()) {
             throw new RuntimeException("Cartão não encontrado");
        }

        Pagamento pagamento = new Pagamento();
        pagamento.setCartao(cartaoOptional.get());
        pagamento.setDescricao(pagamentoDTO.getDescricao());
        pagamento.setValor(pagamentoDTO.getValor());

        return pagamentoRepository.save(pagamento);
    }

    public List<Pagamento> getAllByCartao(Integer cartaoId) {
        return pagamentoRepository.findByCartaoId(cartaoId);
    }
}
