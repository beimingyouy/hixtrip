package com.hixtrip.sample.app.convertor;

import com.hixtrip.sample.client.order.dto.CommandPayDTO;
import com.hixtrip.sample.domain.pay.model.CommandPay;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentConvertor {

    PaymentConvertor INSTANCE = Mappers.getMapper(PaymentConvertor.class);


    CommandPay dtoToDomain(CommandPayDTO dto);

}
