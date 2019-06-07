package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="client1")
public interface Communication {
    @GetMapping("/hi")
    public String communication();
}
