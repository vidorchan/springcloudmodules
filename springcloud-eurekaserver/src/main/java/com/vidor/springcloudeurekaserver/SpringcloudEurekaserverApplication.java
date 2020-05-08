package com.vidor.springcloudeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringcloudEurekaserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaserverApplication.class, args);
    }

}
