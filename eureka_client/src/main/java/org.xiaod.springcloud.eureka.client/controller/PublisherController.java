package org.xiaod.springcloud.eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 【服务提供】 <br/>
 * Created on 15:27 2017/7/14 <br/>
 */
@RestController
public class PublisherController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/hello")
    public String hello(){
        ServiceInstance instance = client.getLocalServiceInstance();
        System.out.println("host:" + instance.getHost());
        return "Hello World";
    }


}
