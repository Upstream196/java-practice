package com.example.annotation_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {


    @Autowired
//    同一类型有多个对应的组件
//    法一：更改属性名
//    法二：使用特定注解指定获取bean的id 注意：@Qualifier需于@Autowired一起使用
    @Qualifier(value = "userServiceImpl")
    private UserService userService;

    public void show(){
        String show = userService.show();
        System.out.println("show="+show);
    }
}
