package com.hixtrip.sample.domain.pay.strategy;

import com.hixtrip.sample.domain.pay.strategy.impl.PaymentDuplicateCallback;
import com.hixtrip.sample.domain.pay.strategy.impl.PaymentFailureCallback;
import com.hixtrip.sample.domain.pay.strategy.impl.PaymentSuccessCallback;
import lombok.Getter;

@Getter
public enum PaymentCallbackStrategy {


    SUCCESS(new PaymentSuccessCallback()),
    FAILURE(new PaymentFailureCallback()),
    DUPLICATE(new PaymentDuplicateCallback());

    private final PaymentCallback paymentCallback;
    public static final String SUCCESS_STR = "SUCCESS";
    public static final String FAILURE_STR = "FAILURE";
    public static final String DUPLICATE_STR = "DUPLICATE";

    PaymentCallbackStrategy(PaymentCallback paymentCallback) {
        this.paymentCallback = paymentCallback;
    }

    public static PaymentCallback getByPayStatus(String payStatus) {
        return switch (payStatus) {
            case SUCCESS_STR -> new PaymentSuccessCallback();
            case FAILURE_STR -> new PaymentFailureCallback();
            case DUPLICATE_STR -> new PaymentDuplicateCallback();
            default -> throw new IllegalArgumentException("pay status error,status : ");
        };
    }

}
