package com.example.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@RestController
public class Controller {

    @Value("${server.port}")
    String port;

    @RequestMapping("/")
    public String hello(){
        return "hello world!" + port;
    }
}
