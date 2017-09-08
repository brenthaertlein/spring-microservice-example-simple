package com.nodemules.spring.microservice.simple.webclient.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author brent
 * @since 9/8/17.
 */
@Controller
public class AccountController {

  private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);

  @Autowired
  AccountRepository accountRepository;

  @RequestMapping("/")
  public ModelAndView home(){

    LOG.info("Going home");

    ModelAndView view = new ModelAndView("index");

    LOG.info("View is named: {}", view.getViewName());

    return view;
  }

  @RequestMapping("/accountList")
  public String accountList(Model model) {
    model.addAttribute("accounts", accountRepository.getAllAccounts());
    return "accountList";
  }

  @RequestMapping("/accountDetails")
  public String accountDetails(@RequestParam("number") String id, Model model) {
    model.addAttribute("account", accountRepository.getAccount(id));
    return "accountDetails";
  }
}
