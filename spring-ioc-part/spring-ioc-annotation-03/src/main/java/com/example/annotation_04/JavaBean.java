package com.example.annotation_04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JavaBean {
//    基本类型属性赋值
//    法一:直接赋值
    private String name="张三";

//    法二：注解赋值->通过value进行赋值,此外value主要用于读取外部信息
    @Value("19")
    private  int age;

//    @Value("${jdbc.username}")
//    设置默认值->1.在@Value("${jdbc.username}")基础上->@Value("${jdbc.username:admin}")
//    2.删去或注解jdbc配置文件中的对应信息,否则默认不生效仍为配置文件中的值
    @Value("${jdbc.username:admin}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Override
    public String toString() {
        return "JavaBean{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
