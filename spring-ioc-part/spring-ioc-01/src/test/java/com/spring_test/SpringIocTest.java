package com.spring_test;


import com.example.JavaBean2;
import com.example.ioc_03.HappyComponent;
import com.example.ioc_4.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {
    @Test 
    public void createIoC()
    {
//        1.直接创建创建容器并指定配置文件->Ioc容器的创建
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");
//        2.读取ioc容器的组件
//        法1：直接根据beanid获取
        HappyComponent component1 = (HappyComponent) applicationContext.getBean("happyComponent", HappyComponent.class);
//        法2：根据beanid，同时指定bean的类型
        HappyComponent component2 = applicationContext.getBean("happyComponent", HappyComponent.class);
//        法3：直接根据类型获取
        HappyComponent component3 = applicationContext.getBean(HappyComponent.class);

      component3.doWork();

        System.out.println(component1==component2);
        System.out.println(component3==component2);

    }
    @Test
    public void test_04(){
//        创建ioc容器会进行组件对象实例化
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-04.xml");

        JavaBean2 bean2=applicationContext.getBean(JavaBean2.class);
        JavaBean2 bean1=applicationContext.getBean(JavaBean2.class);
        System.out.println(bean1==bean2);
        applicationContext.close();
    }

    @Test
    public void test_05(){
//        创建ioc容器会进行组件对象实例化
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-05.xml");

        JavaBean bean2=applicationContext.getBean(JavaBean.class);

        System.out.println("JavaBean="+ com.example.JavaBean.class);

        Object bean = applicationContext.getBean("&javaBean");
        System.out.println("Bean="+bean);

        applicationContext.close();
    }
}
