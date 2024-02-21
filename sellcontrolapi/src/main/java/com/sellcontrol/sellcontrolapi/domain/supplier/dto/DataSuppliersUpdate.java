package com.sellcontrol.sellcontrolapi.domain.supplier.dto;


import com.sellcontrol.sellcontrolapi.domain.address.dto.DataAddress;
import jakarta.validation.constraints.NotNull;

public record DataSuppliersUpdate(
        @NotNull
        Long id,
        String razaoSocial,
        String telefone,
        String email,
        DataAddress endereco) {

}
