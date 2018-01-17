package com.junli.ribbonconsumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author lijun
 * @time 2018-01-12 13:23
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public  String helloService(){
        return restTemplate.getForEntity("http://SPRINGCLOUDDEMO/hello", String.class).getBody();
    }


    public String  helloFallback(){
        return "error";
    }
}
