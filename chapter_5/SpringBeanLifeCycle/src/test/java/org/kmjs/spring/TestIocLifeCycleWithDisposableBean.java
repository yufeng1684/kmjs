package org.kmjs.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIocLifeCycleWithDisposableBean {
    ApplicationContext ctx;
    ProductWtihDisposableBean bean1, bean2;

    @Test
    public void testCase() {
        ctx = new ClassPathXmlApplicationContext("spring-bean-disposable.xml");
        System.out.println("exexute one");
        bean1 = (ProductWtihDisposableBean) ctx.getBean("beanid");
        System.out.println(bean1);
        System.out.println("execute two");
        bean2 = (ProductWtihDisposableBean) ctx.getBean("beanid");
        System.out.println(bean2);
//        ctx.registerShutdownHook();
        ((ClassPathXmlApplicationContext) ctx).close();
    }
}
