package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
public class FindServeController {
    @GetMapping ("/hi")
    public String hi(){
        return "hi,World!";
    }
}
