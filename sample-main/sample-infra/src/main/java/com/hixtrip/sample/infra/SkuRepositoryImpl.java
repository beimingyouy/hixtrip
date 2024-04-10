package com.hixtrip.sample.infra;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hixtrip.sample.domain.commodity.model.Sku;
import com.hixtrip.sample.domain.commodity.repository.SkuRepository;
import com.hixtrip.sample.infra.db.convertor.SkuDoConvertor;
import com.hixtrip.sample.infra.db.dataobject.SkuDO;
import com.hixtrip.sample.infra.db.mapper.SkuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SkuRepositoryImpl implements SkuRepository {

    @Autowired
    private SkuMapper skuMapper;

    @Override
    public Sku getSku(String skuId) {
        SkuDO sku = skuMapper.selectOne(new LambdaQueryWrapper<SkuDO>().eq(SkuDO::getId, skuId));
//        SkuDO sku = SkuDO.builder().id("1").name("sku1").price(new BigDecimal(200)).build();
        return SkuDoConvertor.INSTANCE.doToDomain(sku);
    }

    @Override
    public BigDecimal getSkuPrice(String skuId) {
        SkuDO sku = SkuDO.builder().id("1").name("sku1").price(new BigDecimal(200)).build();
        return sku.getPrice();
    }
}
