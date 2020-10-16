package com.hao.cloudsentinel8100;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudSentinel8100Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudSentinel8100Application.class, args);
    }

}
