package vudinhdo.web.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import vudinhdo.web.travel.dto.TourDTO;
import vudinhdo.web.travel.model.Cities;
import vudinhdo.web.travel.model.Tours;
import vudinhdo.web.travel.repository.TourRepository;
import vudinhdo.web.travel.service.city.CityService;
import vudinhdo.web.travel.service.tour.TourService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class TourController {

    @Autowired
    private CityService cityService;

    @Autowired
    private TourService tourService;

    //ADMIN
    @GetMapping("/admin/tour")
    public String getAllTour(Model model) {
        List<Tours> tours = tourService.getAllTour();
        model.addAttribute("tours", tours);
        model.addAttribute("page", "tour");
        return "admin/layout_admin";
    }

    @GetMapping("/admin/tour-add")
    public String getAddTour(Model model) {
        List<Cities> cities = cityService.getAllCity();
        model.addAttribute("cities", cities);
        model.addAttribute("page", "tour-add");
        return "admin/layout_admin";
    }

    @PostMapping("/admin/tour-add-form")
    public String postAddTour(
            @RequestParam String nameTour,
            @RequestParam String tourCode,
            @RequestParam MultipartFile imageTourOne,
            @RequestParam MultipartFile imageTourTwo,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate,
            @RequestParam LocalDateTime timeCreate,
            @RequestParam MultipartFile imageTourThree,
            @RequestParam Integer priceTour,
            @RequestParam Integer city_id
    ) {

        String uploadDir = "C:\\laragon\\www\\travel\\src\\main\\resources\\static\\assets\\img\\image_tour";
        String imageName1 = StringUtils.cleanPath(Objects.requireNonNull(imageTourOne.getOriginalFilename()));
        String imageName2 = StringUtils.cleanPath(Objects.requireNonNull(imageTourTwo.getOriginalFilename()));
        String imageName3 = StringUtils.cleanPath(Objects.requireNonNull(imageTourThree.getOriginalFilename()));
        try {
            Path uploadPath = Paths.get(uploadDir);
            Files.copy(imageTourOne.getInputStream(), uploadPath.resolve(imageName1), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(imageTourTwo.getInputStream(), uploadPath.resolve(imageName2), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(imageTourThree.getInputStream(), uploadPath.resolve(imageName3), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Tours tours = new Tours();
        tours.setNameTour(nameTour);
        tours.setTourCode(tourCode);
        tours.setImageTourOne(imageName1);
        tours.setImageTourTwo(imageName2);
        tours.setImageTourThree(imageName3);
        tours.setStartDate(startDate);
        tours.setEndDate(endDate);
        tours.setPriceTour(priceTour);
        tours.setTimeCreate(timeCreate);
        tours.setCities(cityService.findCityById(city_id).get());
        tourService.saveTour(tours);
        return "redirect:/admin/tour";
    }

    //CLIENT

    @GetMapping("/destination")
    public String packageFile(Model model){
        List<Tours> tours = tourService.getAllTour();
        List<Cities> cities = cityService.getAllCity();
        List<TourDTO> tourDTOS = new ArrayList<>();
        tours.forEach(obj->{
            TourDTO tourDTO = new TourDTO();
            tourDTO.setId(obj.getId());
            tourDTO.setNameTour(obj.getNameTour());
            tourDTO.setImageTourOne(obj.getImageTourOne());
            tourDTO.setImageTourTwo(obj.getImageTourTwo());
            tourDTO.setImageTourThree(obj.getImageTourThree());
            tourDTO.setStartDate(obj.getStartDate());
            tourDTO.setEndDate(obj.getEndDate());
            tourDTO.setPriceTour(obj.getPriceTour());
            if(obj.getCities() != null){
                tourDTO.setCity_id(obj.getCities().getId());
            }
            tourDTOS.add(tourDTO);
        });
        model.addAttribute("tours" , tourDTOS);
        model.addAttribute("cities" , cities);
        model.addAttribute("page" , "destination");
        return "layout";
    }

    @GetMapping("destination-detail")
    public String getDetailTour(Model model){
        model.addAttribute("page","destination-detail");
        return "layout";
    }
}
