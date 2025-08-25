package com.example.Config;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class MyPointcut {
    @Pointcut("execution(* com.example.Config.Impl.*.*(..))")
    public void pc(){
    }

    @Pointcut("execution(* com.example.Config.Impl.*.*(..))")
    public void dc(){

    }
}
