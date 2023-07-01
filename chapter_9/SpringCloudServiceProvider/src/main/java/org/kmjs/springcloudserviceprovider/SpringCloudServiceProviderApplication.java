package org.kmjs.springcloudserviceprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard
@MapperScan("org.kmjs.springcloudserviceprovider.model.mapper")
public class SpringCloudServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudServiceProviderApplication.class, args);
    }

}
