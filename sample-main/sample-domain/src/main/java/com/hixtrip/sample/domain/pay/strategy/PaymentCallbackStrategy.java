package com.hixtrip.sample.domain.pay.strategy;

import com.hixtrip.sample.domain.pay.PayDomainService;
import com.hixtrip.sample.domain.pay.model.CommandPay;
import org.springframework.beans.factory.annotation.Autowired;

public interface PaymentCallbackStrategy {


    public static String SUCCESS = "SUCCESS";
    public static String FAILURE = "FAILURE";
    public static String DUPLICATE = "DUPLICATE";

    void handle(CommandPay commandPay);
}
