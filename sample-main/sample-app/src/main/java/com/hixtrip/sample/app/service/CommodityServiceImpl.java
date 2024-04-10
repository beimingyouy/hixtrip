package com.hixtrip.sample.app.service;

import com.hixtrip.sample.app.api.CommodityService;
import com.hixtrip.sample.domain.commodity.CommodityDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityDomainService commodityDomainService;

    @Override
    public BigDecimal getSkuPrice(String skuId) {
        return commodityDomainService.getSkuPrice(skuId);
    }
}
