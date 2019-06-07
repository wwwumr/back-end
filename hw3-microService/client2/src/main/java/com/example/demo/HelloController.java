package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
@RestController
public class HelloController{
    @Autowired
    private Communication communication;
    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }
    @GetMapping("/client1_hi")
    public String hi(){
        return communication.communication();
    }
}
