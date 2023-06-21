package org.kmjs.springbootlog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.kmjs.springbootlog.model.mapper")
public class SpringBootLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLogApplication.class, args);
    }

}
