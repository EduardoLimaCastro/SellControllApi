package com.sellcontrol.sellcontrolapi.supplier;

import com.sellcontrol.sellcontrolapi.address.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

//DTO

public record DataSuppliersForm(

        @NotBlank
        String razaoSocial,
        @NotBlank
        String cnpj,
        @Email
        String email,
        @NotBlank
        Address endereco,
        String telefone) {
}
