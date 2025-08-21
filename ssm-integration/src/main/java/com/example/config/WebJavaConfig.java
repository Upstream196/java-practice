package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * projectName: com.atguigu.config
 * 
 * 1.实现Springmvc组件声明标准化接口WebMvcConfigurer 提供了各种组件对应的方法
 * 2.添加配置类注解@Configuration
 * 3.添加mvc复合功能开关@EnableWebMvc
 * 4.添加controller层扫描注解
 * 5.开启默认处理器,支持静态资源处理
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.example.controller")
public class WebJavaConfig implements WebMvcConfigurer {

    //开启静态资源
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

        configurer.enable();
    }
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }
}
