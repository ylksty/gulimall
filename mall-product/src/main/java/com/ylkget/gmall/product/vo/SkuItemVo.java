package com.ylkget.gmall.product.vo;

import com.ylkget.gmall.product.entity.SkuImagesEntity;
import com.ylkget.gmall.product.entity.SkuInfoEntity;
import com.ylkget.gmall.product.entity.SpuInfoDescEntity;
import lombok.Data;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author joe 2021/2/12 22:34
 */
@Data
public class SkuItemVo {
    //1、sku基本信息获取  pms_sku_info
    SkuInfoEntity info;

    boolean hasStock = true;

    //2、sku的图片信息  pms_sku_images
    List<SkuImagesEntity> images;

    //3、获取spu的销售属性组合。
    List<SkuItemSaleAttrVo> saleAttr;

    //4、获取spu的介绍
    SpuInfoDescEntity desp;

    //5、获取spu的规格参数信息。
    List<SpuItemAttrGroupVo> groupAttrs;

    SeckillInfoVo seckillInfo;//当前商品的秒杀优惠信息
}
