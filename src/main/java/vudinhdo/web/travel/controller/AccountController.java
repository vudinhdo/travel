package vudinhdo.web.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vudinhdo.web.travel.model.Accounts;
import vudinhdo.web.travel.service.account.AccountService;

import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/admin/account")
    public String getAllAccount(Model model) {
        List<Accounts> accounts = accountService.getAllAccount();
        model.addAttribute("accounts", accounts);
        model.addAttribute("page", "account");
        return "admin/layout_admin";
    }

    @GetMapping("/admin/account-add")
    public String getAddAccount(Model model) {
        model.addAttribute("page", "account-add");
        return "admin/layout_admin";
    }

    @PostMapping("/admin/account-add-form")
    public String postAddAccount(@RequestParam String fullName,
                                 @RequestParam String username,
                                 @RequestParam String email,
                                 @RequestParam String password,
                                 @RequestParam String phoneNumber) {
        Accounts accounts = new Accounts();
        accounts.setFullName(fullName);
        accounts.setUsername(username);
        accounts.setPassword(password);
        accounts.setEmail(email);
        accounts.setPhoneNumber(phoneNumber);
        accountService.saveAccount(accounts);
        return "redirect:/admin/account";
    }
}
