package br.com.mastertech.cartao.mappers;

import br.com.mastertech.cartao.client.ClienteClient;
import br.com.mastertech.cartao.dtos.Cliente;
import br.com.mastertech.cartao.dtos.CreateCartaoRequest;
import br.com.mastertech.cartao.dtos.GetCartaoResponse;
import br.com.mastertech.cartao.dtos.UpdateCartaoRequest;
import br.com.mastertech.cartao.models.Cartao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartaoMapper {
    @Autowired
    ClienteClient clienteClient;

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

    public GetCartaoResponse toGetCartaoResponse(Cartao cartao) {
        Cliente cliente = clienteClient.getById(cartao.getClienteId());

        GetCartaoResponse getCartaoResponse = new GetCartaoResponse();
        getCartaoResponse.setId(cartao.getId());
        getCartaoResponse.setCliente(cliente);
        getCartaoResponse.setNumero(cartao.getNumero());
        getCartaoResponse.setAtivo(cartao.isAtivo());

        return getCartaoResponse;
    };
}
