package com.ylkget.gmall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ylkget.common.utils.PageUtils;
import com.ylkget.gmall.ware.entity.WareInfoEntity;
import com.ylkget.gmall.ware.vo.FareVo;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author yanglk
 * @email ylksty@163.com
 * @date 2021-01-30 15:10:43
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    FareVo getFare(Long addrId);
}

