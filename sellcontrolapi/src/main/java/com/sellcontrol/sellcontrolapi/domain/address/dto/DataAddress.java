package com.sellcontrol.sellcontrolapi.domain.address.dto;

import com.sellcontrol.sellcontrolapi.utils.Uf;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataAddress(
        @NotBlank
        String logradouro,
        @NotBlank
        String numero,
        String complemento,
        @NotBlank
        String bairro,
        @NotBlank
        String cidade,
        @NotNull
        Uf uf,
        @NotBlank
        String cep) {
}
