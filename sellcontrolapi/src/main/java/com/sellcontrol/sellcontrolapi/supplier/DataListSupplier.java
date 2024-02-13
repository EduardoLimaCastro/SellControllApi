package com.sellcontrol.sellcontrolapi.supplier;

import com.sellcontrol.sellcontrolapi.address.Address;

public record DataListSupplier(Long id, String razaosocial, String cnpj, String email, String telefone, Address endereco) {

    public DataListSupplier(Supplier supplier){
        this(supplier.getId(), supplier.getRazaoSocial(),supplier.getCnpj(),supplier.getEmail(), supplier.getTelefone(), supplier.getEndereco());

    }

}
