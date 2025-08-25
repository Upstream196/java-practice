package com.example.Config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

@Component
@Aspect
public class MyAdvice {
    @Before("com.example.Config.MyPointcut.dc()")
    public void before(JoinPoint joinPoint){
//      1.获取方法属性类的信息
        String name = joinPoint.getTarget().getClass().getName();
//      2.获取方法名称
        int modifiers = joinPoint.getSignature().getModifiers();
        String s = Modifier.toString(modifiers);
        String name1 = joinPoint.getSignature().getName();
//      3.获取参数列表
        Object[] args = joinPoint.getArgs();

    }
    @AfterReturning(value = "com.example.Config.MyPointcut.dc()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){

    }
    @After("com.example.Config.MyPointcut.dc()")
    public void after(JoinPoint joinPoint){

    }
    @AfterThrowing(value = "com.example.Config.MyPointcut.dc()",throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint,Throwable throwable){

    }
}
