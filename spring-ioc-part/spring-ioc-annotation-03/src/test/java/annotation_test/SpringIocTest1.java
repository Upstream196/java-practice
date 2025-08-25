package annotation_test;

import com.example.annotation_01.Dao1;
import com.example.annotation_01.Service1;
import com.example.annotation_02.JavaBean;
import com.example.annotation_03.UserController;
import com.example.annotation_03.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest1 {

@Test
    public void testIoc_01(){
//        1.创建ioc容器
        ClassPathXmlApplicationContext applicationContext= new ClassPathXmlApplicationContext("spring-01.xml");
//2.获取组件
        Dao1 bean=applicationContext.getBean(Dao1.class);
        System.out.println("bean ="+bean);
//        3.添加ioc注解
        Object Service1= (com.example.annotation_01.Service1) applicationContext.getBean("service1");
        System.out.println("Service1 ="+Service1);
    }
@Test
    public void testIoc_02(){
    ClassPathXmlApplicationContext applicationContext= new ClassPathXmlApplicationContext("spring-02.xml");
        JavaBean bean = applicationContext.getBean(JavaBean.class);
        JavaBean bean1=applicationContext.getBean(JavaBean.class);
        System.out.println(bean==bean1);

        applicationContext.close();
    }
    @Test
    public void testIoc_03(){
    ClassPathXmlApplicationContext applicationContext= new ClassPathXmlApplicationContext("spring-03.xml");

        UserController userController=applicationContext.getBean(UserController.class);

        userController.show();
    }

    @Test
    public void testIoc_04(){
    ClassPathXmlApplicationContext applicationContext= new ClassPathXmlApplicationContext("spring-04.xml");

       com.example.annotation_04.JavaBean bean = applicationContext.getBean(com.example.annotation_04.JavaBean.class);

        System.out.println("bean ="+bean);
    }
}