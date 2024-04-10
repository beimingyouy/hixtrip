package com.hixtrip.sample.domain.pay.strategy.context;

import com.hixtrip.sample.domain.pay.model.CommandPay;
import com.hixtrip.sample.domain.pay.strategy.PaymentCallbackStrategy;

/**
 * 支付上下文相关
 */
public class PaymentCallbackContext {

    private final PaymentCallbackStrategy strategy;

    public PaymentCallbackContext(PaymentCallbackStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute(CommandPay commandPay) {
        strategy.handle(commandPay);
    }
}
