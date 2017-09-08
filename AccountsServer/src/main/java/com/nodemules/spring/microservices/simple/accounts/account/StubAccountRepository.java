package com.nodemules.spring.microservices.simple.accounts.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author brent
 * @since 9/8/17.
 */
@Repository
public class StubAccountRepository implements AccountRepository {

  private static final Logger LOG = LoggerFactory.getLogger(StubAccountRepository.class);

  private Map<Long, Account> accountsByNumber = new HashMap<>();

  public StubAccountRepository() {
    String[] names = { "Arnav", "Anamika", "Dinesh", "Rafiki", "Sergey" };
    Account account;
    for (String name : names) {
      account = new Account();
      account.setAmount(Double.valueOf(Math.floor((Math.random() * 9) + 1) * 1000).longValue());
      long id = Double.valueOf(Math.floor(Math.random() * 9999)).longValue();
      account.setId(id);
      account.setName(name);
      accountsByNumber.put(id, account);

    }
    LOG.info("Created StubAccountRepository with {} accounts", accountsByNumber.size());
  }

  @Override
  public List<Account> getAllAccounts() {
    return new ArrayList<Account>(accountsByNumber.values());
  }

  @Override
  public Account getAccount(String number) {
    return accountsByNumber.get(number);
  }
}
