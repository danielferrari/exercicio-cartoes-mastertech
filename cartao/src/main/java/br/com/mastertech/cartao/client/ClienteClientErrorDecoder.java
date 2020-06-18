package br.com.mastertech.cartao.client;

import br.com.mastertech.cartao.exceptions.ClienteNotValidException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class ClienteClientErrorDecoder implements ErrorDecoder {

    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        if (response.status() == 404) {
            return new ClienteNotValidException();
        } else {
            return errorDecoder.decode(s, response);
        }
    }
}
