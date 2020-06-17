package br.com.cartoes.pagamento.dtos;

import java.math.BigDecimal;

public class PagamentoDTO {
    private Integer cartaoId;
    private String descricao;
    private BigDecimal valor;


    public Integer getCartaoId() {
        return cartaoId;
    }

    public void setCartaoId(Integer cartaoId) {
        this.cartaoId = cartaoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
