package com.sellcontrol.sellcontrolapi.domain.orders.buy.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DataBookOrderBuy(
    @NotNull
    Long idSupplier,

    @NotNull
    String item,

    @NotNull
    int quantity,

    @NotNull
    double price,

    @NotNull
    double totalPrice,
    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    LocalDateTime date
) {
}
