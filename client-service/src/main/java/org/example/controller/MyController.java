package org.example.controller;

import org.example.service.ProtectedServiceFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    private final ProtectedServiceFeignClient protectedService;

    public MyController(ProtectedServiceFeignClient protectedService) {
        this.protectedService = protectedService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        var result = protectedService.hello(name);
        return result + ". Request was passed through remote-service (protected-service)";
    }
}
