package org.kmjs.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIocCaseLifeCircleWithInterface {
    ApplicationContext ctx;
    ProductWithInitializingBean bean;
    @Test
    public void testCase(){
        ctx = new ClassPathXmlApplicationContext("spring_bean_initializingBean.xml");
        System.out.println("execute one");
        bean = (ProductWithInitializingBean) ctx.getBean("beanid");
        System.out.println("Produce is " + bean);
        System.out.println("execute two");
        bean = (ProductWithInitializingBean) ctx.getBean("beanid");
        System.out.println("Produce is " + bean);
    }
}
