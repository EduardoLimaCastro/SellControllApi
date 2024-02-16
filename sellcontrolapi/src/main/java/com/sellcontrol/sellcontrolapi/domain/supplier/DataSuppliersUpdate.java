package com.sellcontrol.sellcontrolapi.domain.supplier;


import com.sellcontrol.sellcontrolapi.domain.address.DataAddress;
import jakarta.validation.constraints.NotNull;

public record DataSuppliersUpdate(
        @NotNull
        Long id,
        String razaoSocial,
        String telefone,
        String email,
        DataAddress endereco) {

}
