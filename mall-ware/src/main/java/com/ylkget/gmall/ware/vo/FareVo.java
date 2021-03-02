package com.ylkget.gmall.ware.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author joe 2021/3/2 17:16
 */
@Data
public class FareVo {
    private MemberAddressVo address;
    private BigDecimal fare;
}
