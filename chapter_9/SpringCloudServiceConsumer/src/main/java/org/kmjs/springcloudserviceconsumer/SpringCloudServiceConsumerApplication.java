package org.kmjs.springcloudserviceconsumer;

import org.kmjs.springcloudserviceconsumer.config.LoadBalancerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@LoadBalancerClient(value = "SERVICE-PROVIDER", configuration = LoadBalancerConfig.class)
public class SpringCloudServiceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudServiceConsumerApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
