package com.hao.springcloud.cloudconsumerorder8002;

import com.hao.springcloud.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients(value = "com.hao.springcloud.cloudconsumerorder8002.service")
@RibbonClient(name = "cloud-payment-service", configuration = MySelfRule.class)//专属于“cloud-payment-service”服务的负载规则
@EnableHystrix
@EnableSwagger2
public class CloudConsumerOrder8002Application {

	public static void main(String[] args) {
		SpringApplication.run(CloudConsumerOrder8002Application.class, args);
	}


}
