import com.example.ioc_01.JavaConfiguration;
import com.example.ioc_01.JavaConfigurationA;
import com.example.ioc_01.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringIoCTest {

    @Test
    public void test(){
//        1.创建ioc容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfiguration.class);
//        a.外部包创建
        AnnotationConfigApplicationContext applicationContext1 = new AnnotationConfigApplicationContext();

        applicationContext1.register(JavaConfiguration.class);
        applicationContext1.refresh();

//        2.获取bean
        StudentController bean = applicationContext.getBean(StudentController.class);
        System.out.println("bean ="+bean);
    }

    @Test
    public void test_01(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfigurationA.class);
    }
}
