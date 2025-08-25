package mybatis_test;

import com.example.Students;
import com.example.StudentsMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Students_Test {
    @Test
    public void test_1() throws IOException {
        //1.读取外部配置文件
        InputStream ips= Resources.getResourceAsStream("mapper/students-mybatis.xml");

        //创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        //根据sqLSessionFactory创建sqLSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取接口的代理对象调用代理对象的方法，就会查找mapper接口的方法
        StudentsMapper mapper = sqlSession.getMapper(StudentsMapper.class);

        //插入新用户
        Students students = new Students();
        students.setName("赵八");
        students.setAge(18);
        students.setClasses("六年三班");
        students.setGender("男");
        mapper.insertStudent(students);
        sqlSession.commit();
        //更新用户
        int updateResult = mapper.updateStudent(students);

        sqlSession.commit();
        System.out.println("更新结果为："+updateResult);
        sqlSession.close();
    }


    @Test
    public void searchUsers() throws IOException {
        //1.读取外部配置文件
        InputStream ips= Resources.getResourceAsStream("mapper/students-mybatis.xml");

        //创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        //根据sqLSessionFactory创建sqLSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取接口的代理对象调用代理对象的方法，就会查找mapper接口的方法
        StudentsMapper mapper = sqlSession.getMapper(StudentsMapper.class);

        Map<String, Object> params = new HashMap<>();

        params.put("tableName1","students_2");

        String username = "张三";
        if (username != null && !username.isEmpty()) {
            params.put("username", username);
        }
        Integer age= 18;
        if (age!= null) {
            params.put("age", age);
        }
        List<Students> students = mapper.selectUsersByMap(params);
        System.out.println(students.toString());
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void searchUsersByNameList() throws IOException {
        //1.读取外部配置文件
        InputStream ips= Resources.getResourceAsStream("mapper/students-mybatis.xml");

        //创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        //根据sqLSessionFactory创建sqLSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取接口的代理对象调用代理对象的方法，就会查找mapper接口的方法
        StudentsMapper mapper = sqlSession.getMapper(StudentsMapper.class);

        String tableName = "students_2";

        List<String> nameList = new ArrayList<>();
        nameList.add("张三");
        nameList.add("李四");

        List<Students> students = mapper.selectUsersByNameList(tableName,nameList);
        System.out.println(students.toString());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateStudent() throws IOException {
        //1.读取外部配置文件
        InputStream ips= Resources.getResourceAsStream("mapper/students-mybatis.xml");

        //创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        //根据sqLSessionFactory创建sqLSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取接口的代理对象调用代理对象的方法，就会查找mapper接口的方法
        StudentsMapper mapper = sqlSession.getMapper(StudentsMapper.class);


       List<Students> students = new ArrayList<>();
       Students s1 = new Students();
       s1.setId(1);
       s1.setName("赵六");
       s1.setAge(18);
       students.add(s1);
        int rows = mapper.updateStudent2(students);
        System.out.println("更新了"+rows+"条");
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void updateStudent2() throws IOException {
        //1.读取外部配置文件
        InputStream ips= Resources.getResourceAsStream("mapper/students-mybatis.xml");

        //创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        //根据sqLSessionFactory创建sqLSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取接口的代理对象调用代理对象的方法，就会查找mapper接口的方法
        StudentsMapper mapper = sqlSession.getMapper(StudentsMapper.class);

        List<Students> stu = mapper.selectAllStudents("张三", 18);
        if(stu.isEmpty()){
            System.out.println("没有找到该信息");
            sqlSession.close();
            return;
        }


        for (Students students : stu) {
//            int rows = mapper.updateStudent2(stu);
            students.setAge(20);
        }
//       Students s1 = new Students();
//        s1.setAge((20));
////        s1.setName("张三三");
//        stu.add(s1);

        int rows = mapper.updateStudent2(stu);
        System.out.println("更新了"+rows+"条");
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void updateStudent3() throws IOException {
        //1.读取外部配置文件
        InputStream ips= Resources.getResourceAsStream("mapper/students-mybatis.xml");

        //创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        //根据sqLSessionFactory创建sqLSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取接口的代理对象调用代理对象的方法，就会查找mapper接口的方法
        StudentsMapper mapper = sqlSession.getMapper(StudentsMapper.class);

        List<Students> stu = mapper.selectAllStudents("张三", 18);
        if(stu.isEmpty()){
            System.out.println("没有找到该信息");
            sqlSession.close();
            return;
        }
       for (Students students : stu) {
           students.setAge(100);
       }

        int rows = mapper.batchUpdateStudent(stu);
        System.out.println("更新了"+rows+"条");
        sqlSession.commit();
        sqlSession.close();
    }

    public static void main(String[] args) {
        List<Students> students = null;

        students = new ArrayList<>();


        List<Students> students1 = null;

        System.out.println(students == null);

        System.out.println(students1.isEmpty());


    }
}
