package com.ylkget.gmall.ware.vo;

import lombok.Data;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author joe 2021/3/2 18:24
 */
@Data
public class WareSkuLockVo {
    private String orderSn;//订单号

    private List<OrderItemVo> locks;//需要锁住的所有库存信息
}
