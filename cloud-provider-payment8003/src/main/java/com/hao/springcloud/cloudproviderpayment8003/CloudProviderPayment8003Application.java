package com.hao.springcloud.cloudproviderpayment8003;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.hao.springcloud.cloudproviderpayment8003.mappers")
public class CloudProviderPayment8003Application {

	public static void main(String[] args) {
		SpringApplication.run(CloudProviderPayment8003Application.class, args);
	}

}
