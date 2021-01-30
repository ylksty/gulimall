package com.ylkget.gmall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ylkget.common.utils.PageUtils;
import com.ylkget.gmall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author yanglk
 * @email ylksty@163.com
 * @date 2021-01-30 15:22:59
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

