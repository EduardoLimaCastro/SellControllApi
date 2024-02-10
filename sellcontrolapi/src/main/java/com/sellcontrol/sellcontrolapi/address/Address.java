package com.sellcontrol.sellcontrolapi.address;

import com.sellcontrol.sellcontrolapi.utils.Uf;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.lang.reflect.GenericDeclaration;

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
}
