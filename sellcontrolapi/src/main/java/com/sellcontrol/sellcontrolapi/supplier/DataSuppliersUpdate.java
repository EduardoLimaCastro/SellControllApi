package com.sellcontrol.sellcontrolapi.supplier;


import com.sellcontrol.sellcontrolapi.address.DataAddress;
import jakarta.validation.constraints.NotNull;

public record DataSuppliersUpdate(
        @NotNull
        Long id,
        String razaoSocial,
        String telefone,
        String email,
        DataAddress endereco) {

}
