package com.sellcontrol.sellcontrolapi.domain.orders.buy.dto;

import com.sellcontrol.sellcontrolapi.domain.orders.buy.model.OrderBuy;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DataDetailOrderBuy(
        Long id,
        Long idSupplier,

        String item,

        int quantity,

        double price,

        double totalPrice,
        LocalDateTime data
) {

    public DataDetailOrderBuy(OrderBuy orderBuy) {
        this(orderBuy.getId(), orderBuy.getSupplier().getId(), orderBuy.getItem(),orderBuy.getQuantity(),orderBuy.getPrice(), orderBuy.getTotalPrice(), orderBuy.getDate());
    }
}
