package com.ylkget.gmall.order.feign;

import com.ylkget.gmall.order.vo.MemberAddressVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author joe 2021/3/1 16:09
 */
@FeignClient("server-member")
public interface MemberFeignService {
    @GetMapping("/member/memberreceiveaddress/{memeberId}/addresses")
    List<MemberAddressVo> getAddress(@PathVariable("memeberId") Long memberId);
}
