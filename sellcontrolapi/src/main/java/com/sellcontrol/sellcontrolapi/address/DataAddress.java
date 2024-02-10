package com.sellcontrol.sellcontrolapi.address;

import com.sellcontrol.sellcontrolapi.utils.Uf;

public record DataAddress(
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        Uf uf,
        String cep) {
}
