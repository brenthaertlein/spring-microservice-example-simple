package com.nodemules.spring.microservice.simple.webclient;

import com.nodemules.spring.microservice.simple.webclient.account.AccountRepository;
import com.nodemules.spring.microservice.simple.webclient.account.RemoteAccountRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author brent
 * @since 9/8/17.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class WebclientServerApplication {

  public static final String ACCOUNTS_SERVICE_URL = "http://ACCOUNTS-SERVER";

  public static void main(String[] args) {
    SpringApplication.run(WebclientServerApplication.class, args);
  }

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
  @Bean
  public AccountRepository accountRepository(){
    return new RemoteAccountRepository(ACCOUNTS_SERVICE_URL);
  }
}
