package br.com.cartoes.pagamento.services;

import br.com.cartoes.pagamento.dtos.PagamentoDTO;
import br.com.cartoes.cartao.models.Cartao;
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
