package com.hixtrip.sample.domain.pay.strategy.context;

import com.hixtrip.sample.domain.pay.model.CommandPay;
import com.hixtrip.sample.domain.pay.strategy.PaymentCallback;

/**
 * 支付上下文相关
 */
public class PaymentCallbackContext {

    private final PaymentCallback strategy;

    public PaymentCallbackContext(PaymentCallback strategy) {
        this.strategy = strategy;
    }

    public String execute(CommandPay commandPay) {
        return strategy.handle(commandPay);
    }
}
