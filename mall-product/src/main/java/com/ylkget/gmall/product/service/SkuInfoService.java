package com.ylkget.gmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ylkget.common.utils.PageUtils;
import com.ylkget.gmall.product.entity.SkuInfoEntity;
import com.ylkget.gmall.product.vo.SpuSaveVo;

import java.util.List;
import java.util.Map;

/**
 * sku信息
 *
 * @author yanglk
 * @email ylksty@163.com
 * @date 2021-01-29 22:39:43
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSpuInfo(SpuSaveVo vo);

    void saveSkuInfo(SkuInfoEntity skuInfoEntity);

    PageUtils queryPageByCondition(Map<String, Object> params);

    List<SkuInfoEntity> getSkusBySpuId(Long spuId);
}

