package com.ylkget.gmall.auth.feign;

import com.ylkget.common.utils.R;
import com.ylkget.gmall.auth.vo.SocialUser;
import com.ylkget.gmall.auth.vo.UserLoginVo;
import com.ylkget.gmall.auth.vo.UserRegistVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 *
 * </p>
 *
 * @author joe 2021/2/21 21:00
 */
@FeignClient("service-member")
public interface MemberFeignService {
    @PostMapping("/member/member/regist")
    R regist(@RequestBody UserRegistVo vo);

    @PostMapping("/member/member/login")
    R login(@RequestBody UserLoginVo vo);

    @PostMapping("/member/member/oauth2/login")
    R oauthlogin(@RequestBody SocialUser socialUser) throws Exception;
}
