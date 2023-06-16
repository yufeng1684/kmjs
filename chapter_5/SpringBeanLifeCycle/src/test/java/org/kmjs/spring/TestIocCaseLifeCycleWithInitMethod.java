package org.kmjs.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIocCaseLifeCycleWithInitMethod {
    ApplicationContext ctx;
    ProductWithInitMethod bean;
    @Test
    public void testCase() {
        ctx = new ClassPathXmlApplicationContext("spring-bean-initmethod.xml");
        System.out.println("execute one");
        bean = (ProductWithInitMethod) ctx.getBean("beanid");
        System.out.println("execut two");
        bean = (ProductWithInitMethod) ctx.getBean("beanid");
    }
}
