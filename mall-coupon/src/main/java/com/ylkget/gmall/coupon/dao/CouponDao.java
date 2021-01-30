package com.ylkget.gmall.coupon.dao;

import com.ylkget.gmall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author yanglk
 * @email ylksty@163.com
 * @date 2021-01-30 15:35:16
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
