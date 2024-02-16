package com.sellcontrol.sellcontrolapi.domain.address;

import com.sellcontrol.sellcontrolapi.utils.Uf;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//ENTIDADE JPA
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    @Enumerated(EnumType.STRING)
    private Uf uf;
    private String cep;

    public Address(Address dados) {
        this.logradouro = dados.logradouro;
        this.cep = dados.cep;
        this.uf = dados.uf;
        this.bairro = dados.bairro;
        this.cidade = dados.cidade;
        this.complemento = dados.complemento;
        this.numero = dados.numero;

    }

    public void atualizarEndereco(DataAddress endereco) {
        if (endereco.logradouro() != null) {
            this.logradouro = endereco.logradouro();
        }
        if (endereco.cep() != null) {
            this.cep = endereco.cep();
        }
        if (endereco.uf() != null) {
            this.uf = endereco.uf();
        }
        if (endereco.bairro() != null) {
            this.bairro = endereco.bairro();
        }
        if (endereco.cidade() != null) {
            this.cidade = endereco.cidade();
        }
        if (endereco.complemento() != null) {
            this.complemento = endereco.complemento();
        }
        if (endereco.numero() != null) {
            this.numero = endereco.numero();
        }
    }
}
