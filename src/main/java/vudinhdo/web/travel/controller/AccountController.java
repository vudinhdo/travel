package vudinhdo.web.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import vudinhdo.web.travel.service.account.AccountService;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;
}
