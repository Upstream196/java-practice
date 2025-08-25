package com.example.ioc_01;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({JavaConfigurationB.class})
@Configuration
public class JavaConfigurationA {
}
