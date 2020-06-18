package br.com.mastertech.pagamento.mappers;

import br.com.mastertech.pagamento.dtos.CreatePagamentoRequest;
import br.com.mastertech.pagamento.models.Pagamento;

public class PagamentoMapper {

    public static Pagamento fromCreateRequest(CreatePagamentoRequest createPagamentoRequest) {
        Pagamento pagamento = new Pagamento();
        pagamento.setDescricao(createPagamentoRequest.getDescricao());
        pagamento.setValor(createPagamentoRequest.getValor());
        pagamento.setCartaoNumero(createPagamentoRequest.getCartaoNumero());
        return pagamento;
    }
}
