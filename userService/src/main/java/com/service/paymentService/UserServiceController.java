package com.service.paymentService;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/user")
public class UserServiceController {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod= "fallback", groupKey= "userService", commandKey= "userService", threadPoolKey= "userServiceThread")
    @GetMapping("/go")
    public String userGo(){
        return restTemplate.getForObject("http://payment-service/payment/message",String.class) + "user service";
//        return "this is the user service";
    }

    public String fallback(Throwable hystrixCommand) {
        return "Fall Back Message";
    }

}
