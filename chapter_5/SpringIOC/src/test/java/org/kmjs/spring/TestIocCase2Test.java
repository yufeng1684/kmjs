package org.kmjs.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIocCase2Test {
    ApplicationContext ctx;
    @Test
    public void testCase() {
        ctx = new ClassPathXmlApplicationContext("spring_bean_property.xml");
        Product product = (Product) ctx.getBean("beanProperty");
        System.out.println("property " + product);
    }
}
