package com.ylkget.gmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ylkget.common.utils.PageUtils;
import com.ylkget.gmall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author yanglk
 * @email ylksty@163.com
 * @date 2021-01-29 22:39:43
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();
}

