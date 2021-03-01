package com.ylkget.gmall.order.web;

import com.ylkget.gmall.order.service.OrderService;
import com.ylkget.gmall.order.vo.OrderConfirmVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ExecutionException;

/**
 * <p>
 *
 * </p>
 *
 * @author joe 2021/3/1 15:56
 */
@Controller
public class OrderWebController {

    @Autowired
    OrderService orderService;

    /**
     * 去结算确认页
     * @param model
     * @param request
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @GetMapping("/toTrade")
    public String toTrade(Model model, HttpServletRequest request) throws ExecutionException, InterruptedException {
        OrderConfirmVo confirmVo =  orderService.confirmOrder();

        model.addAttribute("orderConfirmData",confirmVo);
        //展示订单确认的数据
        return "confirm";
    }

}
