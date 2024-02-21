package com.sellcontrol.sellcontrolapi.domain.orders.buy.model;

import com.sellcontrol.sellcontrolapi.domain.supplier.model.Supplier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//Entidade JPA
@Table(name = "orders_buy")
@Entity(name = "Order_Buy")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class OrderBuy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
    private String item;
    private int quantity;
    private double price;
    private double totalPrice;
    private LocalDateTime date;
}
