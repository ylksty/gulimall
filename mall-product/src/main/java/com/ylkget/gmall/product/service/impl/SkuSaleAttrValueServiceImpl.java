package com.ylkget.gmall.product.service.impl;

import com.ylkget.gmall.product.vo.SkuItemSaleAttrVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ylkget.common.utils.PageUtils;
import com.ylkget.common.utils.Query;

import com.ylkget.gmall.product.dao.SkuSaleAttrValueDao;
import com.ylkget.gmall.product.entity.SkuSaleAttrValueEntity;
import com.ylkget.gmall.product.service.SkuSaleAttrValueService;


@Service("skuSaleAttrValueService")
public class SkuSaleAttrValueServiceImpl extends ServiceImpl<SkuSaleAttrValueDao, SkuSaleAttrValueEntity> implements SkuSaleAttrValueService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuSaleAttrValueEntity> page = this.page(
                new Query<SkuSaleAttrValueEntity>().getPage(params),
                new QueryWrapper<SkuSaleAttrValueEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<SkuItemSaleAttrVo> getSaleAttrsBySpuId(Long spuId) {

        SkuSaleAttrValueDao dao =  this.baseMapper;
        List<SkuItemSaleAttrVo> saleAttrVos =  dao.getSaleAttrsBySpuId(spuId);
        return saleAttrVos;

    }

    @Override
    public List<String> getSkuSaleAttrValuesAsStringList(Long skuId) {

        SkuSaleAttrValueDao dao =  this.baseMapper;

        return dao.getSkuSaleAttrValuesAsStringList(skuId);
    }

}