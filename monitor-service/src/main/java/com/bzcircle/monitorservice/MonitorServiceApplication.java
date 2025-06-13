package com.bzcircle.monitorservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@MapperScan("com.bzcircle.monitorservice.dao")
@ComponentScan({
        "com.bzcircle.monitorservice",
        "com.bzcircle.config",
        "com.bzcircle.service",
})
@SpringBootApplication
@EnableDiscoveryClient
public class MonitorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitorServiceApplication.class, args);
    }

}
