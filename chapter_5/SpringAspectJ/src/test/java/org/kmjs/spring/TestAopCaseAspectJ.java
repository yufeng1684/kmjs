package org.kmjs.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAopCaseAspectJ {
    ApplicationContext ctx;
    @Test
    public void testCase() {
        ctx = new ClassPathXmlApplicationContext("spring-bean-aspectj.xml");
        ProductService productService = (ProductService) ctx.getBean(ProductService.class);
        productService.addProduct(4, "aspectj");
        productService.doThrowException();
    }
}
