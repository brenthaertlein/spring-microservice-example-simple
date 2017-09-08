package com.nodemules.spring.microservice.simple.webclient.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author brent
 * @since 9/8/17.
 */
public class RemoteAccountRepository implements AccountRepository {

  private static final Logger LOG = LoggerFactory.getLogger(RemoteAccountRepository.class);

  @Autowired
  protected RestTemplate restTemplate;

  protected String serviceUrl;

  public RemoteAccountRepository(String serviceUrl) {
    this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
        : "http://" + serviceUrl;
    LOG.info("RemoteAccountRepository.serviceUrl set to: {}", serviceUrl);
  }

  @Override
  public List<Account> getAllAccounts() {
    Account[] accounts = restTemplate.getForObject(serviceUrl+"/accounts", Account[].class);
    LOG.info("Found {} accounts", accounts.length);
    return Arrays.asList(accounts);
  }

  @Override
  public Account getAccount(String number) {
    return restTemplate.getForObject(serviceUrl + "/accounts/{id}",
        Account.class, number);
  }
}
