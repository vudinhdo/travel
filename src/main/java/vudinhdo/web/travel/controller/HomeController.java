package vudinhdo.web.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"/","/index"})
    public String index(Model model) {
        model.addAttribute("page" , "index");
        return "layout"; // Trả về tên của trang cụ thể bạn muốn hiển thị
    }

    @GetMapping("/about")
    public String getAbout(Model model){
        model.addAttribute("page" , "about");
        return "layout";
    }
    @GetMapping("/contact")
    public String getContact(Model model){
        model.addAttribute("page" , "contact");
        return "layout";
    }
    @GetMapping("/hotel")
    public String getHotel(Model model){
        model.addAttribute("page" , "hotel");
        return "layout";
    }
    @GetMapping("/blog")
    public String getBlog(Model model){
        model.addAttribute("page" , "blog");
        return "layout";
    }

}
