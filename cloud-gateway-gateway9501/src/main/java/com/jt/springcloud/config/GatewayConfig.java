package com.jt.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: jingteng
 * @date: 2020/7/18 20:46
 * 可以在配置类中配置路由规则，也可以在配置文件中配置
 */
@Configuration
public class GatewayConfig {


    @Bean
    public RouteLocator customRouteLocate(RouteLocatorBuilder locatorBuilder){
        RouteLocatorBuilder.Builder routes = locatorBuilder.routes();
        routes.route("path_route_jt1",
                r ->r.path("/pay/hys/**")
                        .uri("http://localhost:8007"))
                .build();
        return routes.build();
    }
}
