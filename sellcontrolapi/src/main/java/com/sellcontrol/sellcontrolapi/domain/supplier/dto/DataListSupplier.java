package com.sellcontrol.sellcontrolapi.domain.supplier.dto;

import com.sellcontrol.sellcontrolapi.domain.address.model.Address;
import com.sellcontrol.sellcontrolapi.domain.supplier.model.Supplier;

public record DataListSupplier(Long id, String razaosocial, String cnpj, String email, String telefone, Address endereco) {

    public DataListSupplier(Supplier supplier){
        this(supplier.getId(), supplier.getRazaoSocial(),supplier.getCnpj(),supplier.getEmail(), supplier.getTelefone(), supplier.getEndereco());

    }

}
