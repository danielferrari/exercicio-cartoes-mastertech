package br.com.cartoes.cartao.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "O cliente informado é inválido")
public class ClienteNotFoundException extends RuntimeException {
}
