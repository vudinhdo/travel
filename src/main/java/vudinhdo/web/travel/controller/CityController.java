package vudinhdo.web.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import vudinhdo.web.travel.model.Cities;
import vudinhdo.web.travel.service.city.CityService;

import java.time.LocalTime;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Controller
public class CityController {
    @Autowired
    private CityService cityService;
    @GetMapping("/admin/city")
    public String getAllCity(Model model) {
        List<Cities> cities = cityService.getAllCity();
        model.addAttribute("cities", cities);
        model.addAttribute("page", "city");
        return "admin/layout_admin";
    }

    @GetMapping("/admin/city-add")
    public String getAddCity(Model model) {
        model.addAttribute("page", "city-add");
        return "admin/layout_admin";
    }
    @PostMapping("admin/city-add-form")
    public String cityAddForm(
            @RequestParam String nameCity,
            @RequestParam String descriptionCity,
            @RequestParam MultipartFile avatarCity,
            @RequestParam LocalTime timeCreate
    ){
        String uploadDir = "C:\\laragon\\www\\travel\\src\\main\\resources\\static\\assets\\img\\image_city";
        String imageName = StringUtils.cleanPath(Objects.requireNonNull(avatarCity.getOriginalFilename()));
        try {
            Path uploadPath = Paths.get(uploadDir);
            Files.copy(avatarCity.getInputStream(), uploadPath.resolve(imageName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Cities cities = new Cities();
        cities.setNameCity(nameCity);
        cities.setDescriptionCity(descriptionCity);
        cities.setAvatarCity(imageName);
        cities.setTimeCreate(timeCreate);
        cityService.saveCity(cities);
        return "redirect:/admin/city";
    }
}
