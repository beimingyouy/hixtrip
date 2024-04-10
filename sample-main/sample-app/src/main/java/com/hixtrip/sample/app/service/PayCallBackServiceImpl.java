package com.hixtrip.sample.app.service;

import com.hixtrip.sample.app.api.PayCallBackService;
import com.hixtrip.sample.app.convertor.PaymentConvertor;
import com.hixtrip.sample.client.order.dto.CommandPayDTO;
import com.hixtrip.sample.domain.pay.PayDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PayCallBackServiceImpl implements PayCallBackService {

    @Autowired
    private PayDomainService payDomainService;

    @Override
    public String payCallBack(CommandPayDTO dto) {
        return payDomainService.handlePaymentCallback(PaymentConvertor.INSTANCE.dtoToDomain(dto));
    }
}
