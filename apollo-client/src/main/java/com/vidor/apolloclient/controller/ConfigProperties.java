package com.vidor.apolloclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigProperties {

//    @Autowired
    @Value("${spring.application.name}")
    private String name;

    @GetMapping("/getConfig")
    public String getConfig(){
        return name;
    }
}
