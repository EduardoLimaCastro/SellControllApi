package com.sellcontrol.sellcontrolapi.supplier;

import com.sellcontrol.sellcontrolapi.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

//ENTIDADE JPA

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

    public Supplier(DataSuppliersForm dados) {
        this.razaoSocial = dados.razaoSocial();
        this.cnpj = dados.cnpj();
        this.endereco = new Address(dados.endereco());
        this.telefone = dados.telefone();
        this.email = dados.email();
    }
}
