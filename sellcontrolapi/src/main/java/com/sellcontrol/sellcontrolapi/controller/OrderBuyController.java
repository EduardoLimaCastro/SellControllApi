package com.sellcontrol.sellcontrolapi.controller;

import com.sellcontrol.sellcontrolapi.domain.orders.buy.dto.DataBookOrderBuy;
import com.sellcontrol.sellcontrolapi.domain.orders.buy.dto.DataDetailOrderBuy;
import com.sellcontrol.sellcontrolapi.domain.orders.buy.services.OrderBuyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ordersbuy")
public class OrderBuyController {
    @Autowired
    private OrderBuyService orderBuyService;

    @PostMapping
    @Transactional //Escrever em banco de dados
    public ResponseEntity bookOrderBuy(@RequestBody @Valid DataBookOrderBuy data){
        orderBuyService.schedule(data);
        System.out.println(data);
        return ResponseEntity.ok(new DataDetailOrderBuy(null, data.idSupplier(), data.item(), data.quantity(), data.price(), data.totalPrice(), data.date()));
    }
}
