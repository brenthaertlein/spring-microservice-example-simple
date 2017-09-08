package com.nodemules.spring.microservices.simple.accounts.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author brent
 * @since 9/8/17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

  private Long amount;
  private String name;
  private Long id;
}
