package com.sellcontrol.sellcontrolapi.domain.orders.buy.services;

import com.sellcontrol.sellcontrolapi.domain.orders.buy.dto.DataBookOrderBuy;
import com.sellcontrol.sellcontrolapi.domain.orders.buy.dto.DataDetailOrderBuy;
import com.sellcontrol.sellcontrolapi.domain.orders.buy.model.OrderBuy;
import com.sellcontrol.sellcontrolapi.domain.orders.buy.repository.OrderBuyRepository;
import com.sellcontrol.sellcontrolapi.domain.orders.buy.validation.ValidatorOrderBuy;
import com.sellcontrol.sellcontrolapi.domain.supplier.repository.SupplierRepository;
import com.sellcontrol.sellcontrolapi.infra.exception.IdValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//REGRAS DE NEGÓCIO

@Service
public class OrderBuyService {
    @Autowired
    private OrderBuyRepository repository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private List<ValidatorOrderBuy> validators;

    public DataDetailOrderBuy schedule(DataBookOrderBuy data){

        if(!supplierRepository.existsById(data.idSupplier())){
            throw new IdValidacaoException("Id informado não existe");
        }
        
        validators.forEach(v -> v.validate(data));

        var supplier = supplierRepository.getReferenceById(data.idSupplier());
        var orderBuy = new OrderBuy(null, supplier , data.item(),data.quantity(),data.price(),data.totalPrice(),data.date());


        repository.save(orderBuy);
        return new DataDetailOrderBuy(orderBuy);
    }

}
