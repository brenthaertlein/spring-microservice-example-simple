package com.nodemules.spring.microservices.simple.accounts.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author brent
 * @since 9/8/17.
 */
@RestController
public class AccountController {

  private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);


  @Autowired
  AccountRepository accountRepository;

  @RequestMapping("/accounts")
  public Account[] all() {
    LOG.info("accounts-microservice all() invoked");
    List<Account> accounts = accountRepository.getAllAccounts();
    LOG.info("accounts-microservice all() found: " + accounts.size());
    return accounts.toArray(new Account[accounts.size()]);
  }

  @RequestMapping("/accounts/{id}")
  public Account byId(@PathVariable("id") String id) {
    LOG.info("accounts-microservice byId() invoked: " + id);
    Account account = accountRepository.getAccount(id);
    LOG.info("accounts-microservice byId() found: " + account);
    return account;
  }
}
