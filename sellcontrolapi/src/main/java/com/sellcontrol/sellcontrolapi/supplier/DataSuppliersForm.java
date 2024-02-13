package com.sellcontrol.sellcontrolapi.supplier;

import com.sellcontrol.sellcontrolapi.address.Address;
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
        @Email
        String email,
        @NotNull
        @Valid
        Address endereco,
        String telefone) {
}
