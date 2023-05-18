package com.attendance.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhouyihang
 * @version 1.0
 * @description: TODO
 * @date 2023/5/14 15:03
 */
@Configuration
public class SysWebConfig implements WebMvcConfigurer {

    private static final List<String> EXCLUDE_PATH = Arrays.asList("/","/login","/doLogin", "/static/**");


    @Autowired
    private SysInterceptor sysInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sysInterceptor).addPathPatterns("/**").excludePathPatterns(EXCLUDE_PATH);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
