package com.example.annotation_03;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

//@Controller//场景2：取消注解
@Service
public class UserServiceImpl implements UserService{

    @Override
    public String show() {
        return "UserServiceImpl show();";
    }
}
