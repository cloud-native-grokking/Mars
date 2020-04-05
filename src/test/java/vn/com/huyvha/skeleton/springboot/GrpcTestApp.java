package com.cloudnative.grokking.mars;

import org.lognet.springboot.grpc.GRpcService;
import org.redisson.spring.starter.RedissonAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vietdv272
 */
@SpringBootApplication(
        exclude = {
                RedisAutoConfiguration.class,
                RedissonAutoConfiguration.class,
                //
                KafkaAutoConfiguration.class,
                //
                JmsAutoConfiguration.class,
                //
                HibernateJpaAutoConfiguration.class,
                DataSourceAutoConfiguration.class,
        }
)
@ComponentScan(
        basePackages = "com.cloudnative.grokking.mars.controller",
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = GRpcService.class),
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = RestController.class)
)
public class GrpcTestApp {

    public static void main(String[] args) {
        SpringApplication.run(GrpcTestApp.class, args);
    }
}
