package org.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${remote-service.name}", url = "${remote-service.url}")
public interface ProtectedServiceFeignClient {

    @GetMapping("/hello")
    String hello(@RequestParam String name);
}
