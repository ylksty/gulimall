package com.ylkget.gmall.member.controller;

import java.util.Arrays;
import java.util.Map;

import com.ylkget.common.exception.BizCodeEnume;
import com.ylkget.gmall.member.feign.CouponFeignService;
import com.ylkget.gmall.member.vo.MemberLoginVo;
import com.ylkget.gmall.member.vo.MemberRegistVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ylkget.gmall.member.entity.MemberEntity;
import com.ylkget.gmall.member.service.MemberService;
import com.ylkget.common.utils.PageUtils;
import com.ylkget.common.utils.R;

import javax.annotation.Resource;


/**
 * 会员
 *
 * @author yanglk
 * @email ylksty@163.com
 * @date 2021-01-30 12:02:09
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Resource
    private CouponFeignService couponFeignService;

    /*
    http://127.0.0.1:8000/member/member/coupons
     */
    @RequestMapping("/coupons")
    public R feigntest(){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setNickname("fireNay");
        // 远程调用
        System.out.println(couponFeignService);
        R memberCoupons = couponFeignService.memberCoupons();
        return R.ok().put("member", memberEntity).put("coupons", memberCoupons.get("coupons"));
    }

    @PostMapping("/login")
    public R login(@RequestBody MemberLoginVo vo){

        MemberEntity entity =  memberService.login(vo);
        if(entity!=null){
            return R.ok().setData(entity);
        }else{
            return R.error(BizCodeEnume.LOGINACCT_PASSWORD_INVAILD_EXCEPTION.getCode(),BizCodeEnume.LOGINACCT_PASSWORD_INVAILD_EXCEPTION.getMsg());
        }
    }

    @PostMapping("/regist")
    public R regist(@RequestBody MemberRegistVo vo){

        memberService.regist(vo);

        return R.ok();
    }

    /**
     * 列表
     */
    /*
    http://127.0.0.1:8000/member/member/list
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:member:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:member:info")
    public R info(@PathVariable("id") Long id){
		MemberEntity member = memberService.getById(id);

        return R.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:member:save")
    public R save(@RequestBody MemberEntity member){
		memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:member:update")
    public R update(@RequestBody MemberEntity member){
		memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:member:delete")
    public R delete(@RequestBody Long[] ids){
		memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
