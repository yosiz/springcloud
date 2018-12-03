package com.service.paymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/payment")
public class PaymentServiceController {

    @Value("${eureka.instance.instanceId}")
    private String instanceId;

    @GetMapping("/message")
    public String userGo(){
       return "this is the a payment (got it from: "+instanceId+" )";
    }

}
