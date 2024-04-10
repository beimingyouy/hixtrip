package com.hixtrip.sample.infra.db.convertor;

import com.hixtrip.sample.domain.commodity.model.Sku;
import com.hixtrip.sample.infra.db.dataobject.SkuDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SkuDoConvertor {

    SkuDoConvertor INSTANCE = Mappers.getMapper(SkuDoConvertor.class);

    Sku doToDomain(SkuDO skuDO);
}
