import com.example.JavaConfig;
import com.example.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringIocTest {
    @Test
    public void tsst(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(JavaConfig.class);

        StudentController controller=applicationContext.getBean(StudentController.class);

        controller.findAll();
    }

}
