package com.ylkget.common.to.mq;

import lombok.Data;

/**
 * <p>
 * StockLockedTo
 * </p>
 *
 * @author joe 2021/3/2 18:43
 */
@Data
public class StockLockedTo {
    private Long id; //库存工作单的id
    private StockDetailTo detail;//工作详情的所有id
}
