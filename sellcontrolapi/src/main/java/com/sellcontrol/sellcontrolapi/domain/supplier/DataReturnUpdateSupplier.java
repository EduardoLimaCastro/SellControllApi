package com.sellcontrol.sellcontrolapi.domain.supplier;

import com.sellcontrol.sellcontrolapi.domain.address.Address;

public record DataReturnUpdateSupplier(Long id, String razaoSocial, String cnpj , String email, Address endereco, String telefone, boolean ativo) {

    public DataReturnUpdateSupplier(Supplier supplier) {
        this(supplier.getId(), supplier.getRazaoSocial(), supplier.getCnpj(), supplier.getEmail(),supplier.getEndereco(), supplier.getTelefone(), supplier.isAtivo());
    }
}
