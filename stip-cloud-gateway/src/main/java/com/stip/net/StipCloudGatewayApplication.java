package com.stip.net;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableAutoConfiguration
public class StipCloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(StipCloudGatewayApplication.class, args);
    }
}

