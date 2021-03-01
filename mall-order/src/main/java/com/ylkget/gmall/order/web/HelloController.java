package com.ylkget.gmall.order.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>
 *
 * </p>
 *
 * @author joe 2021/3/1 14:56
 */

@Controller
public class HelloController {
    @GetMapping("/{page}.html")
    public String listPage(@PathVariable("page") String page){

        return page;
    }
}
