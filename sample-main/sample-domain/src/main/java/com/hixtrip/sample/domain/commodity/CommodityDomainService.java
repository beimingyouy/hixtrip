package com.hixtrip.sample.domain.commodity;

import com.hixtrip.sample.domain.commodity.model.Sku;
import com.hixtrip.sample.domain.commodity.repository.SkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * 商品领域服务
 */
@Component
public class CommodityDomainService {

    @Autowired
    private SkuRepository skuRepository;

    public BigDecimal getSkuPrice(String skuId) {
        return null == skuRepository.getSku(skuId) ? new BigDecimal("200.5") : skuRepository.getSku(skuId).getPrice();
    }

}
