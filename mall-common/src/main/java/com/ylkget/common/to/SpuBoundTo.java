package com.ylkget.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author joe 2021-02-04 15
 */
@Data
public class SpuBoundTo {
    private Long spuId;
    private BigDecimal buyBounds;
    private BigDecimal growBounds;
}
