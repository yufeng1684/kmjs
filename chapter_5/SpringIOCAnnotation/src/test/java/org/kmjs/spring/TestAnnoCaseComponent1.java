package org.kmjs.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnoCaseComponent1 {
    ApplicationContext ctx;
    ProductService productService;

    @Test
    public void testCase(){
        ctx = new ClassPathXmlApplicationContext("spring-bean-scan.xml");
        productService = (ProductService) ctx.getBean("productService");
        productService.addProduct(100, "autowired");
    }
}
