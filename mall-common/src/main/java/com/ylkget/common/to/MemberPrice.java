package com.ylkget.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author joe 2021-02-04 13
 */
@Data
public class MemberPrice {
    private Long id;
    private String name;
    private BigDecimal price;
}
