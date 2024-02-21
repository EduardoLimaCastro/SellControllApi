package com.sellcontrol.sellcontrolapi.domain.supplier.dto;

import com.sellcontrol.sellcontrolapi.domain.address.model.Address;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//DTO

public record DataSuppliersForm(

        @NotBlank
        String razaoSocial,
        @NotBlank
        String cnpj,
        @Email(message = "email não está no formato correto")
        String email,
        @NotNull
        @Valid
        Address endereco,
        String telefone) {
}
