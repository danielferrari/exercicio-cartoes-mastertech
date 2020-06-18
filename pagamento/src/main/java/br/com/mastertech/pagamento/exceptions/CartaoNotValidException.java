package br.com.mastertech.pagamento.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "O cartão informado é inválido")
public class CartaoNotValidException extends RuntimeException {
}
