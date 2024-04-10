package com.hixtrip.sample.app.convertor;

import com.hixtrip.sample.client.commodity.vo.SkuVO;
import com.hixtrip.sample.domain.commodity.model.Sku;
import com.hixtrip.sample.infra.db.dataobject.SkuDO;
import org.mapstruct.factory.Mappers;

public interface SkuDoConvertor {

    SkuDoConvertor INSTANCE = Mappers.getMapper(SkuDoConvertor.class);

    SkuVO domainTOVo(Sku sku);
}
