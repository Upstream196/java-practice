package com.example.ioc_4;


import org.springframework.beans.factory.FactoryBean;

public class JavaBeanFactoryBean implements FactoryBean<JavaBean>{

    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public JavaBean getObject() throws Exception {
             JavaBean javaBean = new JavaBean();
             javaBean.setName(value);
             return javaBean;
         }

    public Class<?> getObjectType() {
        return JavaBean.class;
    }
}
