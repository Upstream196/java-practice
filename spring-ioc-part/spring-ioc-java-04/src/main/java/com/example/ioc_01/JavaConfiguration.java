package com.example.ioc_01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@ComponentScan("com.example.ioc_01") //->包扫描注解配置
@PropertySource(value = "classpath:jdbc.properties") //->引用外部配置文件
@Configuration //->声明为配置类
public class JavaConfiguration {
    @Value("${example.url}")
    private String url;

    @Value("${example.driver}")
    private String driver;

    @Value("${example.username}")
    private String username;

    @Value("${example.password}")
    private String password;
/**
 * xml配置bean方法
 * 方法的返回值类型==bean组件的类型或者其他的接口和父类
 * 方法的名字=bean id
 * 方法体可以自定义实现过程即可
 * @Bean 会真正配置类的方法创建组件存储到ioc容器中
 */


    /**
     * @Bean注解使用过程中可能会遇到的问题
     *
     * 问题1：beanName的问题
     *     a.组件名通常默认为方法名 即下方法的dataSource
     *     b.可以使用name/value指定
     *
     * 问题2：周期方法如何指定
     *     a.原有注解方案：在对应的方法名上添加 @PostConstruct->实例化之后调用 与 @PreDestroy->销毁之前调用 标签
     *     b.bean属性指定：在指定完beanName名之后添加 initMethod/destroyMethod方法
     *     注意：beanName名之后添加 initMethod/destroyMethod方法需要用","分隔开
     *
     * 问题3：作用域
     *       使用@Scope注解默认是单列
     *
     * 问题4：如何引用其他的ioc组件
     *       直接调用对方的bean方法即可
     *       直接使用形参变量进行引入，要求必须有对应的组件否则报错.
     *       若有多个形参变量,给形参名赋予对应的组件id标识即可
     */
    //@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean(value = "zhangsan") //->声明第三方依赖
    public DataSource dataSource1() {
//        具体实现实例化的过程
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(value = "lisi") //->声明第三方依赖
    public DataSource dataSource2() {
//        具体实现实例化的过程
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource1());
//        需要DataSource或是需要ioc容器的其他组件
//        方案1：如果其他组件也是@Bean方法，可以直接调用->从ioc容器获取组件
        jdbcTemplate.setDataSource(dataSource1());
        return jdbcTemplate;
    }
    @Bean
    public JdbcTemplate jdbcTemplate1(DataSource zhangsan,DataSource lisi){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource1());
//        需要DataSource或是需要ioc容器的其他组件
//        方案2：形参列表声明想要的组件类型，可以是一个也可以是多个(推荐)
//        注意:如果有多个形参对象可以使用形参名称等同于对应的bean id标识即可
       jdbcTemplate.setDataSource(zhangsan);
        return jdbcTemplate;
    }
}
