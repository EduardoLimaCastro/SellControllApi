package com.sellcontrol.sellcontrolapi.domain.supplier;

import com.sellcontrol.sellcontrolapi.domain.address.Address;

public record DataListSupplier(Long id, String razaosocial, String cnpj, String email, String telefone, Address endereco) {

    public DataListSupplier(Supplier supplier){
        this(supplier.getId(), supplier.getRazaoSocial(),supplier.getCnpj(),supplier.getEmail(), supplier.getTelefone(), supplier.getEndereco());

    }

}
