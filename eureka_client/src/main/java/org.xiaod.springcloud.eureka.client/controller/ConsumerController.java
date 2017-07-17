package org.xiaod.springcloud.eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Description: 【服务消费】 <br/>
 * Created on 10:26 2017/7/17 <br/>
 *
 */
@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/consumer", method = RequestMethod.GET)
    public String helloConsumer(){
        return restTemplate.getForEntity("http://EUREKAPUBLISHER/hello", String.class).getBody();
    }

}
