package com.service.paymentService;

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


    @GetMapping("/go")
    public String userGo(){
        return restTemplate.getForObject("http://localhost:8001/payment/message",String.class) + "user service";
//        return "this is the user service";
    }

}
