package com.hao.springcloud.cloudproviderpayment8003;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.hao.springcloud.cloudproviderpayment8003.mapper")
public class CloudProviderPayment8003Application {

	public static void main(String[] args) {
		SpringApplication.run(CloudProviderPayment8003Application.class, args);
	}



    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


}
