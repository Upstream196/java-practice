import com.example.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {
    @Test
    public void test() {
       ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring.01.xml");

        StudentController controller=applicationContext.getBean(StudentController.class);

        controller.findAll();
    }
}
