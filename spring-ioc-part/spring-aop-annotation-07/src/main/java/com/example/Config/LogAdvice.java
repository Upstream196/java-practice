package com.example.Config;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class LogAdvice {

    @Before("com.example.Config.MyPointcut.pc()")
    public void start(){
        System.out.println("方法开始了");
    }

    @After("com.example.Config.MyPointcut.pc()")
    public void after(){
        System.out.println("方法结束了");
    }

    @AfterThrowing("com.example.Config.MyPointcut.pc()")
    public void error(){
        System.out.println("方法报错了");
    }
}
