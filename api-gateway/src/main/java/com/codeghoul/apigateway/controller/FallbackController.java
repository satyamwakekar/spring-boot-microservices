package com.codeghoul.apigateway.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

  @HystrixCommand
  @GetMapping("/user-service-fallback")
  public String userServiceFallback() {
    return "User Service is taking longer than expected. Please try again later";
  }

  @HystrixCommand
  @GetMapping("/department-service-fallback")
  public String departmentServiceFallback() {
    return "Department Service is taking longer than expected. Please try again later";
  }
}
