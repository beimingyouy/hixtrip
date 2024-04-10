package com.hixtrip.sample.infra;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hixtrip.sample.domain.commodity.model.Sku;
import com.hixtrip.sample.domain.commodity.repository.SkuRepository;
import com.hixtrip.sample.domain.order.repository.OrderRepository;
import com.hixtrip.sample.infra.db.convertor.SkuDoConvertor;
import com.hixtrip.sample.infra.db.dataobject.SkuDO;
import com.hixtrip.sample.infra.db.mapper.SkuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderRepositoryImpl implements OrderRepository {




}
