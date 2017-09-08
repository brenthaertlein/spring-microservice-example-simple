package com.nodemules.spring.microservices.simple.accounts.account;

import java.util.List;

/**
 * @author brent
 * @since 9/8/17.
 */
public interface AccountRepository {
  List<Account> getAllAccounts();

  Account getAccount(String number);
}
