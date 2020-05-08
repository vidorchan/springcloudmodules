package com.vidor.springcloudcommon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudCommonApplication.class, args);
    }

}
