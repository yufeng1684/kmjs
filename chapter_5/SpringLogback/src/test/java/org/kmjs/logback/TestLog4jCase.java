package org.kmjs.logback;

import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.slf4j.Logger;

public class TestLog4jCase {
    private final Logger logger = LoggerFactory.getLogger(TestLog4jCase.class);
    ApplicationContext context=null;
    @Test
    public void testCase(){
        context = new ClassPathXmlApplicationContext("spring-bean.xml");
        logger.debug("debug");
        logger.info("test");
        logger.warn("warn");
        logger.error("error");
    }
}
