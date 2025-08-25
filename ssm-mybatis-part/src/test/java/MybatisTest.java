import com.example.Employee;
import com.example.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

    @Test
    public void test_01() throws IOException {
//        System.out.println("Classpath: " + System.getProperty("java.class.path"));
        //1.读取外部配置文件
        InputStream ips= Resources.getResourceAsStream("mapper/Mybatis.xml");

        //创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ips);

        //根据sqLSessionFactory创建sqLSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取接口的代理对象调用代理对象的方法，就会查找mapper接口的方法
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.queryById(1);
        System.out.println("employee ="+employee);


        //提交事务和释放资源
        sqlSession.commit();
        sqlSession.close();
    }
}
