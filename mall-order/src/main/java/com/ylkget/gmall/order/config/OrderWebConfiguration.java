package com.ylkget.gmall.order.config;

import com.ylkget.gmall.order.interceptor.LoginUserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>
 * OrderWebConfiguration
 * </p>
 *
 * @author joe 2021/3/1 16:44
 */
@Configuration
public class OrderWebConfiguration implements WebMvcConfigurer {
    @Autowired
    LoginUserInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/**");
    }
}
