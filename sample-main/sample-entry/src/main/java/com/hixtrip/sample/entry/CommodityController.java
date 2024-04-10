package com.hixtrip.sample.entry;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.hixtrip.sample.app.api.CommodityService;
import com.hixtrip.sample.client.commodity.dto.SkuReq;
import com.hixtrip.sample.client.order.dto.CommandOderCreateDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @GetMapping(path = "/query/commodity/getSkuPrice")
    public BigDecimal getSkuPrice(@RequestBody SkuReq req) {
        //模拟req
        if (StringUtils.isBlank(req.getSkuId())) {
            req.setSkuId("1");
        }
        return commodityService.getSkuPrice(req.getSkuId());
    }
}
