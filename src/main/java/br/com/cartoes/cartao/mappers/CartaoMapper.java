package br.com.cartoes.cartao.mappers;

import br.com.cartoes.cartao.dtos.CreateCartaoRequest;
import br.com.cartoes.cartao.dtos.UpdateCartaoRequest;
import br.com.cartoes.cartao.models.Cartao;
import br.com.cartoes.cliente.models.Cliente;

public class CartaoMapper {

    public static Cartao fromCreateRequest(CreateCartaoRequest createCartaoRequest) {
        Cliente cliente = new Cliente();
        cliente.setId(createCartaoRequest.getClienteId());

        Cartao cartao = new Cartao();
        cartao.setNumero(createCartaoRequest.getNumero());
        cartao.setCliente(cliente);

        return cartao;
    }

    public static Cartao fromUpdateRequest(UpdateCartaoRequest updateCartaoRequest) {
        Cartao cartao = new Cartao();

        cartao.setAtivo(updateCartaoRequest.getAtivar());

        return cartao;
    }
}
