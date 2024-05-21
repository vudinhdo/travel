package vudinhdo.web.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vudinhdo.web.travel.model.Accounts;
import vudinhdo.web.travel.service.account.AccountService;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AccountService accountService;


    @GetMapping("/admin")
    public String getIndexAdmin(Model model) {
        model.addAttribute("page", "index");
        return "admin/layout_admin";
    }

    @GetMapping("/admin/login")
    public String getLoginAdmin(Model model) {
        model.addAttribute("page", "login-form-admin");
        return "admin/layout_admin";
    }

    @GetMapping("/admin/button")
    public String getButtonAdmin(Model model) {
        model.addAttribute("page", "button");
        return "admin/layout_admin";
    }

    @GetMapping("/admin/blank")
    public String getBlankAdmin(Model model) {
        model.addAttribute("page", "blank");
        return "admin/layout_admin";
    }

    @GetMapping("/admin/card")
    public String getCardAdmin(Model model) {
        model.addAttribute("page", "card");
        return "admin/layout_admin";
    }

    @GetMapping("/admin/chart")
    public String getChartAdmin(Model model) {
        model.addAttribute("page", "chart");
        return "admin/layout_admin";
    }

    @GetMapping("/admin/table")
    public String getTableAdmin(Model model) {
        model.addAttribute("page", "table");
        return "admin/layout_admin";
    }

    @GetMapping("/admin/animation")
    public String getAnimationAdmin(Model model) {
        model.addAttribute("page", "animation");
        return "admin/layout_admin";
    }

    @GetMapping("/admin/border")
    public String getBorderAdmin(Model model) {
        model.addAttribute("page", "border");
        return "admin/layout_admin";
    }

    @GetMapping("/admin/color")
    public String getColorAdmin(Model model) {
        model.addAttribute("page", "color");
        return "admin/layout_admin";
    }

    @GetMapping("/admin/other")
    public String getOtherAdmin(Model model) {
        model.addAttribute("page", "other");
        return "admin/layout_admin";
    }

    @GetMapping("/admin/error")
    public String getErrorAdmin(Model model) {
        model.addAttribute("page", "error");
        return "admin/layout_admin";
    }






}
