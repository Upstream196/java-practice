package com.example.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringIoClnit {

    public class MyWebApppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

        @Override
        protected Class<?>[] getRootConfigClasses() {
            return new Class[]{DataSourceJavaConfig.class, MapperJavaConfig.class, ServiceJavaConfig.class};
        }

        @Override
        protected Class<?>[] getServletConfigClasses() {
            return new Class[]{WebJavaConfig.class};
        }

        @Override
        protected String[] getServletMappings() {
            return new String[]{"/"};
        }
    }
}
