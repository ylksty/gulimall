package com.ylkget.gmall.member.dao;

import com.ylkget.gmall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author yanglk
 * @email ylksty@163.com
 * @date 2021-01-30 12:02:09
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
