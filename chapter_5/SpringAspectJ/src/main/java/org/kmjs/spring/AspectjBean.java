package org.kmjs.spring;

import org.aspectj.lang.annotation.*;

@Aspect
public class AspectjBean {
    @Pointcut("execution(* org.kmjs.spring.ProductService.*(..))")
    private void businessService() {

    }

    @Before("businessService()")
    public void beforeService() {
        System.out.println("beforeService -> Going to exec addProduct");
    }

    @After("businessService()")
    public void afterService() {
        System.out.println("afterService -> addProduct has been done");
    }

    @AfterReturning(pointcut = "businessService()", returning = "retVal")
    public void afterReturningService(Object retVal) {
        System.out.println("afterReturningService -> Returning");
    }

    @AfterThrowing(pointcut = "businessService()", throwing = "exp")
    public void afterThrowingService(IllegalArgumentException exp) {
        System.out.println("afterThrowingService -> There has been an exception:" + exp.toString());
    }
}
