package com.hao.springcloud.cloudgatewaygateway9527.config;


import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class GateWayConfig {




    /*@Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {


        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        *//*lambda表达式*//*
        routes.route("payment_hystrix",
                r -> r.path("/payment/hystrix/**").uri("http://localhost:8001")).build();


        routes.route("news_baidu", new Function<PredicateSpec, Route.AsyncBuilder>() {
            @Override
            public Route.AsyncBuilder apply(PredicateSpec predicateSpec) {
                return predicateSpec.path("/**").uri("http://news.baidu.com");
            }
        }).build();

        return routes.build();

    }*/





}
