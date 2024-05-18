package vudinhdo.web.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormController {
    @GetMapping("/login")
    public String GetLoginForm(Model model) {
        return "login";
    }

}
