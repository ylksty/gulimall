package com.ylkget.gmall.member.feign;

import com.ylkget.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author joe
 * @create 2021-01-30 18:05
 */
@FeignClient("server-coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/feign/demo")
    R memberCoupons();
}
