package br.com.mastertech.cartao.mappers;

import br.com.mastertech.cartao.dtos.CreateCartaoRequest;
import br.com.mastertech.cartao.dtos.UpdateCartaoRequest;
import br.com.mastertech.cartao.models.Cartao;
import br.com.mastertech.cliente.models.Cliente;

public class CartaoMapper {

    public static Cartao fromCreateRequest(CreateCartaoRequest createCartaoRequest) {
        Cartao cartao = new Cartao();
        cartao.setNumero(createCartaoRequest.getNumero());
        cartao.setClienteId(createCartaoRequest.getClienteId());

        return cartao;
    }

    public static Cartao fromUpdateRequest(UpdateCartaoRequest updateCartaoRequest) {
        Cartao cartao = new Cartao();

        cartao.setAtivo(updateCartaoRequest.getAtivar());

        return cartao;
    }
}
