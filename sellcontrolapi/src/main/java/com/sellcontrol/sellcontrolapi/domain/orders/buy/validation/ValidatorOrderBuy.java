package com.sellcontrol.sellcontrolapi.domain.orders.buy.validation;

import com.sellcontrol.sellcontrolapi.domain.orders.buy.dto.DataBookOrderBuy;

public interface ValidatorOrderBuy {

    public void validate(DataBookOrderBuy data);
}
