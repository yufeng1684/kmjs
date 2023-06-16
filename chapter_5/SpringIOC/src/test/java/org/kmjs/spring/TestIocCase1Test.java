package org.kmjs.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIocCase1Test {
    ApplicationContext ctx;
    @Test
    public void testCase() {
        ctx = new ClassPathXmlApplicationContext("spring_bean_constructor.xml");
        Product product = (Product) ctx.getBean("beanNoConstructor");
        System.out.println("No constructor arg " + product);
        Product product1 = (Product) ctx.getBean("beanHasConstructor");
        System.out.println("Has constructor arg " + product1);

    }
}
