package com.hao.openfeign9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CloudOpenfeign9001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudOpenfeign9001Application.class, args);
    }

}
