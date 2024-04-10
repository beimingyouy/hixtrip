package com.hixtrip.sample.infra.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hixtrip.sample.infra.db.dataobject.SkuDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * sku mapper
 */
@Mapper
public interface SkuMapper extends BaseMapper<SkuDO> {
}
