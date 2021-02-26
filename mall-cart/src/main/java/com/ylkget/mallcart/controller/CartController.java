package com.ylkget.mallcart.controller;

import com.ylkget.mallcart.service.CartService;
import com.ylkget.mallcart.service.impl.CartServiceImpl;
import com.ylkget.mallcart.vo.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.ExecutionException;

/**
 * <p>
 * CartController
 * </p>
 *
 * @author joe 2021/2/25 16:11
 */
@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    /**
     *
     * 浏览器有一个cookie；user-key；标识用户身份，一个月后过期；
     * 如果第一次使用jd的购物车功能，都会给一个临时的用户身份；
     * 浏览器以后保存，每次访问都会带上这个cookie；
     *
     * 登录：session有
     * 没登录：按照cookie里面带来user-key来做。
     * 第一次：如果没有临时用户，帮忙创建一个临时用户。
     * @return
     */
    @GetMapping("/cart.html")
    public String cartListPage(Model model) throws ExecutionException, InterruptedException {
        //1、快速得到用户信息，id，user-key
//        System.out.println(userInfoTo);

//        Cart cart = cartService.getCart();
//        model.addAttribute("cart",cart);
//        return "cartList";
        return "success";
    }
}
