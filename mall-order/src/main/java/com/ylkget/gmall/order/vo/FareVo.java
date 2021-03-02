package com.ylkget.gmall.order.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author joe 2021/3/2 11:37
 */
@Data
public class FareVo {
    private MemberAddressVo address;
    private BigDecimal fare;
}
