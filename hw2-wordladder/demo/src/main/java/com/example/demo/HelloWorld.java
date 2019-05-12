package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping("/hello")
    public String index() {
        return "Hello Spring Boot,Index!";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "Spring Boot Test Demo!";
    }
}