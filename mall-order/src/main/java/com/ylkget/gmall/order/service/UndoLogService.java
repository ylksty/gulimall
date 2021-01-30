package com.ylkget.gmall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ylkget.common.utils.PageUtils;
import com.ylkget.gmall.order.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author yanglk
 * @email ylksty@163.com
 * @date 2021-01-30 15:22:59
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

