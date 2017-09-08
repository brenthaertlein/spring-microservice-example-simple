package com.nodemules.spring.microservice.simple.discovery.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author brent
 * @since 9/7/17.
 */
@SpringBootApplication
@EnableEurekaServer
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
