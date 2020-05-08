package com.vidor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class SpringCloudGateway {
    public static void main(String[] args){
        SpringApplication.run(SpringCloudGateway.class, args);
    }
}
