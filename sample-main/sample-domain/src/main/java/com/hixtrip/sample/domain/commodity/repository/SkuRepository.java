package com.hixtrip.sample.domain.commodity.repository;

import com.hixtrip.sample.domain.commodity.model.Sku;

import java.math.BigDecimal;

/**
 * sku接口 , infra实现这边的查询逻辑
 */
public interface SkuRepository {

    Sku getSku(String skuId);

    BigDecimal getSkuPrice(String skuId);
}
