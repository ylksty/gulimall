package com.ylkget.gmall.product.dao;

import com.ylkget.gmall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author yanglk
 * @email ylksty@163.com
 * @date 2021-01-29 22:39:43
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
