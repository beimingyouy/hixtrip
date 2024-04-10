package com.hixtrip.sample.client.commodity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SkuVO {

    private String skuId;

    private String name;
    private BigDecimal price;
    private String code;
    private String msg;

}
