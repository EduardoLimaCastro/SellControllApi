package com.sellcontrol.sellcontrolapi.domain.orders.buy.validation;

import com.sellcontrol.sellcontrolapi.domain.orders.buy.dto.DataBookOrderBuy;
import com.sellcontrol.sellcontrolapi.infra.exception.CreateException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidatorTime implements  ValidatorOrderBuy{
    public void validate(DataBookOrderBuy data){
        var dateBuy = data.date();
        System.out.println(dateBuy);
        var sunday = dateBuy.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var timebefore = dateBuy.getHour() < 8;
        var timeafter = dateBuy.getHour() > 18;

        if(sunday || timebefore || timeafter){
            throw new CreateException("Agendamento de compra fora do horário de funcionamento");
        }
    }
}
