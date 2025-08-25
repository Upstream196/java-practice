import com.example.users.User;
import com.example.users.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class User_mybatis_test {

    @Test
    public void test_01() throws IOException {
        //1.读取外部配置文件
        InputStream ips = Resources.getResourceAsStream("mapper/mybatis-config01.xml");

        //创建sSqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        //根据SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取接口代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //调用方法进行查询
        User user = mapper.getUserById(1);
        System.out.println("user ="+user);

        //插入新用户
        User newuser = new User(1001,"newUser","password123","new@example.com");
        int insertResult = mapper.insertUser(newuser);
        System.out.println("插入结果 ："+insertResult+", 新用户ID："+newuser.getId());

        //更新用户
        newuser.setEmail("update@example.com");
        int updateResult = mapper.updateUser(newuser);
        System.out.println("更新结果为："+updateResult);

        //查询所有用户
        List<User> allUsers = mapper.getAllUsers();
        System.out.println("所有用户：");
        allUsers.forEach(System.out::println);//->这步的作用是什么？


    }




    @Test
    public void update() throws IOException {

        //1.读取外部配置文件
        InputStream ips = Resources.getResourceAsStream("mapper/mybatis-config01.xml");

        //创建sSqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        //根据SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取接口代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);



        //插入新用户
        User newuser = new User(1001,"newUser1","123","qq@example.com");
        //更新用户
        int updateResult = mapper.updateUser(newuser);

        sqlSession.commit();

        System.out.println("更新结果为："+updateResult);



    }


    @Test
    public void update11() throws IOException {

        //1.读取外部配置文件
        InputStream ips = Resources.getResourceAsStream("mapper/mybatis-config01.xml");

        //创建sSqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        //根据SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取接口代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        User user = new User();

        //插入新用户
        //更新用户
        int updateResult = mapper.updateUser1("333","222","111","111","111","222");

        sqlSession.commit();

        System.out.println("更新结果为："+updateResult);



    }

    @Test
    public void insert() throws IOException {

        //1.读取外部配置文件
        InputStream ips = Resources.getResourceAsStream("mapper/mybatis-config01.xml");

        //创建sSqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        //根据SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取接口代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //插入新用户
        User newuser = new User(null,"newUser","password123","new@example.com");
        int insertResult = mapper.insertUser(newuser);
        System.out.println("插入结果 ："+insertResult+", 新用户ID："+newuser.getId());
        sqlSession.commit();

        User newuser1 = new User(null,"newUser","password123","new@example.com");
        int insertResult1 = mapper.insertUser(newuser1);
        System.out.println("插入结果 ："+insertResult+", 新用户ID："+newuser1.getId());
        sqlSession.commit();
        //事务关闭
        sqlSession.close();
    }


    @Test
    public void delete() throws IOException {

        //1.读取外部配置文件
        InputStream ips = Resources.getResourceAsStream("mapper/mybatis-config01.xml");

        //创建sSqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        //根据SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取接口代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


//        //删除用户
//        int deleteResult = mapper.deleterUser("222","222");
//        System.out.println("删除结果："+deleteResult);
        sqlSession.commit();

        //事务关闭
        sqlSession.close();
    }



    @Test
    public void update1() throws IOException {

        //1.读取外部配置文件
        InputStream ips = Resources.getResourceAsStream("mapper/mybatis-config01.xml");

        //创建sSqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        //根据SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取接口代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);



        //插入新用户
        User newuser = new User(1001,"newUser","password123456","new@example.com");
        //更新用户
        int updateResult = mapper.updateUser(newuser);

        sqlSession.commit();

        System.out.println("更新结果为："+updateResult);



    }

    @Test
    public void delete1() throws IOException {

        //1.读取外部配置文件
        InputStream ips = Resources.getResourceAsStream("mapper/mybatis-config01.xml");

        //创建sSqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        //根据SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取接口代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);


        User user = new User();
        user.setUsername("newUser");
        user.setEmail("222");
        //删除用户
        int deleteResult = mapper.deleterUser(user);
        System.out.println("删除结果：" + deleteResult);
        sqlSession.commit();

        //事务关闭
        sqlSession.close();
    }

    @Test
    public void select() throws IOException {
        //1.读取外部配置文件
        InputStream ips = Resources.getResourceAsStream("mapper/mybatis-config01.xml");

        //创建sSqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        //根据SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取接口代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User userById = mapper.getUserByUsername("222","111","111");
        System.out.println(userById);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void select1() throws IOException {
        //1.读取外部配置文件
        InputStream ips = Resources.getResourceAsStream("mapper/mybatis-config01.xml");

        //创建sSqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        //根据SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取接口代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("222");
        user.setPassword("111");
        user.setEmail("111");


//        User userByUsername1 = mapper.getUserByUsername1("111","222","333");
        User userByUsername1 = mapper.getUserByUsername1(user);
        System.out.println(userByUsername1);
        sqlSession.commit();
        sqlSession.close();
    }
}
