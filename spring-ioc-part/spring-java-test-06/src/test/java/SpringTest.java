import com.example.A;
import com.example.B;
import com.example.JavaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value = JavaConfig.class )//注意locations指定配置xml文件，value指定配置类
//使用该注解可以让注解创建ioc容器
public class SpringTest {
    @Autowired
    private A a;
    @Autowired
    private B b;
    @Test
    public void tsst(){
        System.out.println(a);
    }

}
