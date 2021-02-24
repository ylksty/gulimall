package com.ylkget.gmall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ylkget.common.utils.PageUtils;
import com.ylkget.gmall.member.entity.MemberEntity;
import com.ylkget.gmall.member.excepiton.UsernameExistException;
import com.ylkget.gmall.member.exception.PhoneExsitException;
import com.ylkget.gmall.member.vo.MemberLoginVo;
import com.ylkget.gmall.member.vo.MemberRegistVo;

import java.util.Map;

/**
 * 会员
 *
 * @author yanglk
 * @email ylksty@163.com
 * @date 2021-01-30 12:02:09
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void regist(MemberRegistVo vo);

    void checkPhoneUnique(String phone) throws PhoneExsitException;

    void checkUsernameUnique(String username) throws UsernameExistException;

    MemberEntity login(MemberLoginVo vo);
}

