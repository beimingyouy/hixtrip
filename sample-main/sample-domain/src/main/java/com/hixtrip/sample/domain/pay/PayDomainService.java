package com.hixtrip.sample.domain.pay;

import com.hixtrip.sample.domain.pay.model.CommandPay;
import com.hixtrip.sample.domain.pay.strategy.PaymentCallbackStrategy;
import com.hixtrip.sample.domain.pay.strategy.context.PaymentCallbackContext;
import com.hixtrip.sample.domain.pay.strategy.impl.PaymentDuplicateCallbackStrategy;
import com.hixtrip.sample.domain.pay.strategy.impl.PaymentFailureCallbackStrategy;
import com.hixtrip.sample.domain.pay.strategy.impl.PaymentSuccessCallbackStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 支付领域服务
 * todo 不需要具体实现, 直接调用即可
 */
@Component
public class PayDomainService {

    /**
     * 记录支付回调结果
     * 【高级要求】至少有一个功能点能体现充血模型的使用。
     */
    public void payRecord(CommandPay commandPay) {
        //无需实现，直接调用即可

        commandPay.sendPayStatus();
        commandPay.savePayLog();
    }


    /**
     * 回调接口
     *
     * @param commandPay
     */
    public void handlePaymentCallback(CommandPay commandPay) {
        PaymentCallbackStrategy strategy = switch (commandPay.getPayStatus()) {
            case PaymentCallbackStrategy.SUCCESS -> new PaymentSuccessCallbackStrategy();
            case PaymentCallbackStrategy.FAILURE -> new PaymentFailureCallbackStrategy();
            case PaymentCallbackStrategy.DUPLICATE -> new PaymentDuplicateCallbackStrategy();
            default -> throw new IllegalArgumentException("pay status error,status : " + commandPay.getPayStatus());
        };

        PaymentCallbackContext context = new PaymentCallbackContext(strategy);
        context.execute(commandPay);
    }
}
