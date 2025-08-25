package com.example.jdbc;

public class Student {
    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private String classes;

    public Integer getAge() {
        return age;
    }

    public String getClasses() {
        return classes;
    }

    public Integer getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
}

