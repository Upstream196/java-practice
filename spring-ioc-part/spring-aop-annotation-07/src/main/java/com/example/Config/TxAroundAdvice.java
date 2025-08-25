package com.example.Config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class TxAroundAdvice {

    @Around("com.example.Config.MyPointcut.pc()")
    public Object transaction(ProceedingJoinPoint pjp)  {
        Object[] args = pjp.getArgs();
        Object result = null;
     try {
         System.out.println("开启事务");
         result = pjp.proceed(args);

     } catch (Throwable e) {
         System.out.println("事务回滚");
         throw new RuntimeException(e);
     }
      return result;
    }
}
