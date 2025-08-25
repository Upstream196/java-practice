package com.example.ioc_02;

public class UserService {
    private UserDao userDao;
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    private int age;
    private String name;

    public UserService(int age, String name,UserDao userDao) {
        this.age = age;
        this.name = name;
        this.userDao = userDao;
    }
}
