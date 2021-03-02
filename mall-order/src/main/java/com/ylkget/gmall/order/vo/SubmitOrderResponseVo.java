package com.ylkget.gmall.order.vo;

import com.ylkget.gmall.order.entity.OrderEntity;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author joe 2021/3/2 11:30
 */
@Data
public class SubmitOrderResponseVo {

    private OrderEntity order;
    private Integer code;//0成功   错误状态码
}
