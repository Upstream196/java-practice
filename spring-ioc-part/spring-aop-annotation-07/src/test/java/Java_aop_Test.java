import com.example.Config.Impl.Calculator;
import com.example.Config.JavaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value = JavaConfig.class)
public class Java_aop_Test {
    @Autowired
    private Calculator calculator;

    @Test
    public void test(){
        int add = calculator.add(1, 0);
        System.out.println(add);
    }
}
