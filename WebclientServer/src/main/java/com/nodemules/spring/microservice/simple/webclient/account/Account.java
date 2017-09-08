package com.nodemules.spring.microservice.simple.webclient.account;

import lombok.Data;

/**
 * @author brent
 * @since 9/8/17.
 */
@Data
public class Account {

  private Long amount;
  private String number;
  private String name;

}
