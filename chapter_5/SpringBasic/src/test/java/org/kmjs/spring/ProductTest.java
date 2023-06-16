package org.kmjs.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductTest {
    ApplicationContext ctx;
    @Test
    public void testCase() {
        ctx = new ClassPathXmlApplicationContext("spring-basic.xml");
        Product product = (Product) ctx.getBean("beanId");
        System.out.println(product);
    }
}
