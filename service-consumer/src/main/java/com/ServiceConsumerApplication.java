package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by yang on 2018/1/8.
 */
@ComponentScan("com")
@EntityScan("com")
@SpringCloudApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableSwagger2
public class ServiceConsumerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerApplication.class, args);
    }
}
