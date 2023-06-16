package org.kmjs.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIocCase3Test {
    ApplicationContext ctx;
    @Test
    public void testCase() {
        ctx = new ClassPathXmlApplicationContext("spring_bean_scope.xml");
        Product product = (Product) ctx.getBean("beanNoScope");
        Product product1 = (Product) ctx.getBean("beanNoScope");
        System.out.println("Is equal: " + (product1 == product));

        Product product2 = (Product)ctx.getBean("beanPrototype");
        Product product3 = (Product)ctx.getBean("beanPrototype");
        System.out.println("Is equal: " + (product2 == product3));

    }
}
