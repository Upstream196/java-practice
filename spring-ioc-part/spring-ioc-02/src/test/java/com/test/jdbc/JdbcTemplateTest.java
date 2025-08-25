package com.test.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.jdbc.Student;
import com.example.jdbc.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateTest
{
    public void testForJava()
    {
//     1.创建一个对象池
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setUrl("jdbc:mysql:///studb");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //    2.实例化对象
        JdbcTemplateTest jdbcTemplateTest = new JdbcTemplateTest();
        jdbcTemplateTest.setDataSource(dataSource);

    }

    private void setDataSource(DruidDataSource dataSource) {
    }
    @Test
    public void testForIoC()
    {
//        1.创建ioc容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");

//        获取jdbcTemplate组件
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

//        进行数据库curd动作
        String sql="insert into students(id, name,gender, age,class) values(?,?,?,?,?)";

        int rows =jdbcTemplate.update(sql,8,"张三","男",18,"三年二班");
        System.out.println("rows ="+rows);
        sql="select * from students where id=8";

        Student student1=jdbcTemplate.queryForObject(sql, (rs,rowNum)->
                 {
                     Student student = new Student();
                     student.setId(rs.getInt("id"));
                     student.setName(rs.getString("name"));
                     student.setAge(rs.getInt("age"));
                     student.setGender(rs.getString("gender"));
                     student.setClasses(rs.getString("class"));
                     return student;
                 });

        System.out.println("student1=" + student1);

        sql="select id,name,gender,age,class as classes from students ;";
        List<Student> studentList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Student>(Student.class));
        System.out.println("studentList=" + studentList);
    }

@Test
    public void testQueryAll(){
//        创建ioc容器
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-02.xml");
//        2.获取组件对象
    StudentController controller=applicationContext.getBean(StudentController.class);
//    3.使用组件对象
    controller.findAll();
//    4.关闭容器
    applicationContext.close();
   }
}
