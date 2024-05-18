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
    public String about(Model model){
        model.addAttribute("page" , "about");
        return "layout";
    }

    @GetMapping("/Error404")
    public String file404(Model model){
        model.addAttribute("page" , "Error404");
        return "layout";
    }

    @GetMapping("/booking")
    public String booking(Model model){
        model.addAttribute("page" , "booking");
        return "layout";
    }

    @GetMapping("/contact")
    public String contact(Model model){
        model.addAttribute("page" , "contact");
        return "layout";
    }

    @GetMapping("/destination")
    public String destination(Model model){
        model.addAttribute("page" , "destination");
        return "layout";
    }

    @GetMapping("/package")
    public String packageFile(Model model){
        model.addAttribute("page" , "package");
        return "layout";
    }

    @GetMapping("/service")
    public String service(Model model){
        model.addAttribute("page" , "service");
        return "layout";
    }

    @GetMapping("/team")
    public String team(Model model){
        model.addAttribute("page" , "team");
        return "layout";
    }

    @GetMapping("/testimonial")
    public String testimonial(Model model){
        model.addAttribute("page" , "testimonial");
        return "layout";
    }
    
}
