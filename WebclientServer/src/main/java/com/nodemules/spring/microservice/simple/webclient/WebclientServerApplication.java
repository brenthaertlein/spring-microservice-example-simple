package com.nodemules.spring.microservice.simple.webclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author brent
 * @since 9/8/17.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class WebclientServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebclientServerApplication.class, args);
  }
}
