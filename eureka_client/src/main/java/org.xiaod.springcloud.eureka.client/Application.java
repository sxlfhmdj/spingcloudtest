package org.xiaod.springcloud.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Discription: [SpringBoot Main]
 * Created on: 15:52 2017/7/10
 */
@Configuration
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("org.xiaod.springcloud.eureka.client")
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
