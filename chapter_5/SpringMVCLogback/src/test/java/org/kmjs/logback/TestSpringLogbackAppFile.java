package org.kmjs.logback;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringLogbackAppFile {
    private static final Logger logger = LoggerFactory.getLogger(TestSpringLogbackAppFile.class);
    static ApplicationContext ctx = null;
    @Test
    public void testCase() {
        ctx = new ClassPathXmlApplicationContext("spring-bean.xml");
        for(int i =0; i < 20000; i++) {
            logger.debug("debug" + i);
            logger.info("test");
            logger.warn("warn" + i);
            logger.error("error" + i);
        }
    }

}
