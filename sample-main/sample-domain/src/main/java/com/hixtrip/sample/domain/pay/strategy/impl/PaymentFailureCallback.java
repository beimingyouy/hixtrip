package com.hixtrip.sample.domain.pay.strategy.impl;

import com.hixtrip.sample.domain.pay.PayDomainService;
import com.hixtrip.sample.domain.pay.model.CommandPay;
import com.hixtrip.sample.domain.pay.strategy.PaymentCallback;
import com.hixtrip.sample.domain.pay.strategy.PaymentCallbackStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentFailureCallback implements PaymentCallback {

    @Autowired
    public PayDomainService payDomainService;
    @Override
    public String handle(CommandPay commandPay) {
        System.out.println("payment failure , return ");
        //处理后续逻辑
        payDomainService.payRecord(commandPay);
        return PaymentCallbackStrategy.FAILURE_STR;
    }
}
