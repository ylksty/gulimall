package com.ylkget.gmall.product.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author joe 2021-02-06 22
 */
@Controller
public class IndexController {
    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
