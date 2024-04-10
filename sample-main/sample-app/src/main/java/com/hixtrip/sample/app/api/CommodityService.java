package com.hixtrip.sample.app.api;

import java.math.BigDecimal;

public interface CommodityService {

    BigDecimal getSkuPrice(String skuId);
}
