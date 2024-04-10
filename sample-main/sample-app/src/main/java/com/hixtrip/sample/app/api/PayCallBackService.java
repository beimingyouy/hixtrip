package com.hixtrip.sample.app.api;

import com.hixtrip.sample.client.order.dto.CommandPayDTO;

public interface PayCallBackService {


    String payCallBack(CommandPayDTO dto);
}
