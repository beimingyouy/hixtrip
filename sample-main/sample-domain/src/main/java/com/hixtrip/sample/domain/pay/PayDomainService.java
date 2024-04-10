package com.hixtrip.sample.domain.pay;

import com.hixtrip.sample.domain.pay.model.CommandPay;
import com.hixtrip.sample.domain.pay.strategy.PaymentCallback;
import com.hixtrip.sample.domain.pay.strategy.PaymentCallbackStrategy;
import com.hixtrip.sample.domain.pay.strategy.context.PaymentCallbackContext;
import com.hixtrip.sample.domain.pay.strategy.impl.PaymentDuplicateCallback;
import com.hixtrip.sample.domain.pay.strategy.impl.PaymentFailureCallback;
import com.hixtrip.sample.domain.pay.strategy.impl.PaymentSuccessCallback;
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
    public String handlePaymentCallback(CommandPay commandPay) {
        PaymentCallback strategy = PaymentCallbackStrategy.getByPayStatus(commandPay.getPayStatus());
        PaymentCallbackContext context = new PaymentCallbackContext(strategy);
        return context.execute(commandPay);

    }
}
