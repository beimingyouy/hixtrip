package com.hixtrip.sample.domain.pay.strategy.impl;

import com.hixtrip.sample.domain.pay.PayDomainService;
import com.hixtrip.sample.domain.pay.model.CommandPay;
import com.hixtrip.sample.domain.pay.strategy.PaymentCallbackStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentSuccessCallbackStrategy implements PaymentCallbackStrategy {

    @Autowired
    public PayDomainService payDomainService;


    @Override
    public void handle(CommandPay commandPay) {
        System.out.println("payment success , continue ");
        //处理后续逻辑
        payDomainService.payRecord(commandPay);
    }
}
