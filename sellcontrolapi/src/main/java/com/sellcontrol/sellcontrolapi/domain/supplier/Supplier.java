package com.sellcontrol.sellcontrolapi.domain.supplier;

import com.sellcontrol.sellcontrolapi.domain.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

//ENTIDADE JPA do Supplier

@Table(name = "suppliers")
@Entity(name = "Supplier")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Supplier {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String razaoSocial;
    private String cnpj;
    private String email;
    @Embedded
    private Address endereco;
    private String telefone;
    private boolean ativo;

    public Supplier(DataSuppliersForm dados) {
        this.ativo = true;
        this.razaoSocial = dados.razaoSocial();
        this.cnpj = dados.cnpj();
        this.endereco = new Address(dados.endereco());
        this.telefone = dados.telefone();
        this.email = dados.email();
    }

    public void updateInfo(DataSuppliersUpdate supplier) {
        if (supplier.razaoSocial() != null) {
            this.razaoSocial = supplier.razaoSocial();
        }
        if (supplier.telefone() != null) {
            this.telefone = supplier.telefone();
        }
        if (supplier.email() != null) {
            this.email = supplier.email();
        }
        if (supplier.endereco() != null) {
            this.endereco.atualizarEndereco(supplier.endereco());
        }
    }

    public void deleteActive() {
        this.ativo = false;
    }
}
