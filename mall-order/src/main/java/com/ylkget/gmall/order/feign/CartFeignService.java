package com.ylkget.gmall.order.feign;

import com.ylkget.gmall.order.vo.OrderItemVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author joe 2021/3/1 16:23
 */
@FeignClient("server-cart")
public interface CartFeignService {
    @GetMapping("/currentUserCartItems")
    List<OrderItemVo> getCurrentUserCartItems();
}
