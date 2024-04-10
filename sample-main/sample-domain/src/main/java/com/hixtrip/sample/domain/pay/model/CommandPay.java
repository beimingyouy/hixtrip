package com.hixtrip.sample.domain.pay.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommandPay {

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 订单状态
     */
    private String payStatus;

    public void sendPayStatus(){
        //根据支付状态来进行消息推送
    }
    public void savePayLog(){
        //记录支付日志 ...
    }
}