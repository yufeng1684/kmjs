package org.kmjs.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnoCaseComponent {
    ApplicationContext ctx;
    IProductDao productDao;
//    ProductDaoImpl productDao;
    @Test
    public void testCase() {
        ctx = new ClassPathXmlApplicationContext("spring-bean-scan.xml");
        productDao = (ProductDaoImpl) ctx.getBean("productDaoImpl");
        System.out.println("productDao is " + productDao);
        System.out.println(productDao.addProduct(2, "kmjs anno"));
    }
}
