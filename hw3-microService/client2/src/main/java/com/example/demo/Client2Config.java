package com.example.demo;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class Client2Config {
    @Bean
    public IPing ribbonPing(IClientConfig config){
        return new PingUrl();
    }
}