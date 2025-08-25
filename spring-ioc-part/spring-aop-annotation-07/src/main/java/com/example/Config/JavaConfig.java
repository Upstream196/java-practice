package com.example.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.example.Config") //-未扫描到加强配置无法进行日志配置，因为文件不在同一目录下
@EnableAspectJAutoProxy//->开启aspectj的注解
public class JavaConfig {
}
