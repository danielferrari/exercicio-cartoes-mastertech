package br.com.cartoes.cartao.models;

import br.com.cartoes.cliente.models.Cliente;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String numero;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private boolean ativo = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getCliente() {
        return cliente.getId();
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
