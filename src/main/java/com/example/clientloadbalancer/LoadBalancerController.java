package com.example.clientloadbalancer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadBalancerController {

    @Autowired
    LoadBalancerService service;

    @GetMapping("/test")
    public String test() {
        return service.getData();
    }
}
