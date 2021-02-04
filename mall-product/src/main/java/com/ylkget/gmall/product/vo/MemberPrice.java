package com.ylkget.gmall.product.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author joe 2021-02-04 12
 */
@Data
public class MemberPrice {
    private Long id;
    private String name;
    private BigDecimal price;
}
