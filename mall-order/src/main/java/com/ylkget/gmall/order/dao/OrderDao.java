package com.ylkget.gmall.order.dao;

import com.ylkget.gmall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author yanglk
 * @email ylksty@163.com
 * @date 2021-01-30 15:22:59
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
