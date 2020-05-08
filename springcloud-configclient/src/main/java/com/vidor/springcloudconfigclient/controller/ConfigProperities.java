package com.vidor.springcloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigProperities {

//    @Autowired
    @Value("${spring.application.name}")
    private String name;

    @GetMapping("/getConfig")
    public String getConfig(){
        return name;
    }
}
