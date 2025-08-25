package com.example.annotation_02;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON) //->单例
//@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE) //多例
@Component
public class JavaBean {
//    周期方法命名随意 但是必须是无参 public类型
    @PostConstruct//实例化之后调用
    public void init(){
        System.out.println("JavaBean init");
    }
     @PreDestroy//销毁之前调用
    public void destroy(){
        System.out.println("JavaBean destroy");
    }
}
