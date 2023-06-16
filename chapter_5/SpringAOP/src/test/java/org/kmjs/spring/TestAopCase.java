package org.kmjs.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAopCase {
    ProductService productService;
    ApplicationContext ctx;
    @Test
    public void testCase() {
        ctx = new ClassPathXmlApplicationContext("spring-bean-aop.xml");
        productService = (ProductService) ctx.getBean(ProductService.class);
        productService.addProduct(3, "spring aop");
    }
}
