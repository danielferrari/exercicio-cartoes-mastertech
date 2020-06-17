package br.com.cartoes.pagamento.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "O cartão informado é invalido")
public class CartaoNotFoundException extends RuntimeException {
}
