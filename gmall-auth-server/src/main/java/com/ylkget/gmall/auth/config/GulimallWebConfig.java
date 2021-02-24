package com.ylkget.gmall.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>
 * GulimallWebConfig
 * </p>
 *
 * @author joe 2021/2/23 10:46
 */
@Configuration
public class GulimallWebConfig implements WebMvcConfigurer {
    /**
     * 视图映射
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        /**
         *     @GetMapping("/login.html")
         *     public String loginPage(){
         *
         *         return "login";
         *     }
         */
//        registry.addViewController("/login.html").setViewName("login");
        //只是get请求能映射
        registry.addViewController("/reg.html").setViewName("reg");
    }
}
