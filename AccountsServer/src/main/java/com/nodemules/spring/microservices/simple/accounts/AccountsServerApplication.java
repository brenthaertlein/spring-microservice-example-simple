package com.nodemules.spring.microservices.simple.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author brent
 * @since 9/7/17.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AccountsServerApplication {
  public static void main(String[] args) {
    SpringApplication.run(AccountsServerApplication.class, args);
  }
}
