package vudinhdo.web.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vudinhdo.web.travel.dto.BookingDTO;
import vudinhdo.web.travel.model.Accounts;
import vudinhdo.web.travel.model.Booking;
import vudinhdo.web.travel.model.Tours;
import vudinhdo.web.travel.service.account.AccountService;
import vudinhdo.web.travel.service.booking.BookingService;
import vudinhdo.web.travel.service.tour.TourService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private TourService tourService;
    @Autowired
    private AccountService accountService;

    @GetMapping("/admin/booking")
    public String getAllBookingByAdmin(Model model) {
        List<Booking> bookings = bookingService.getAllBooking();
        List<Accounts> accounts = accountService.getAllAccount();
        List<Tours> tours = tourService.getAllTour();
        List<BookingDTO> bookingDTOS = new ArrayList<>();
        bookings.forEach(obj -> {
            BookingDTO bookingDTO = new BookingDTO();
            bookingDTO.setDateBooking(obj.getDateBooking());
            bookingDTO.setNumberPeople(obj.getNumberPeople());
            if (obj.getTours() != null && obj.getAccounts() != null) {
                bookingDTO.setAccount_id(obj.getAccounts().getId());
                bookingDTO.setTour_id(obj.getTours().getId());
            }
            bookingDTOS.add(bookingDTO);
        });
        model.addAttribute("bookings", bookingDTOS);
        model.addAttribute("tours", tours);
        model.addAttribute("accounts", accounts);
        model.addAttribute("page", "admin-booking-table");
        return "admin/layout_admin";
    }

    @GetMapping("/destination-detail/{id}/booking")
    public String getBookingPage(Model model, @PathVariable(name = "id") Integer idTour) {
        Tours tours = tourService.findTourById(idTour);
        model.addAttribute("tour", tours);
        model.addAttribute("page", "booking");
        return "layout";
    }

//    @PostMapping("/booking-tour")
//    public String postBookingTour(@RequestParam String fullName,
//                                  @RequestParam String email,
//                                  @RequestParam String phoneNumber,
//                                  @RequestParam Integer numberPeople,
//                                  @RequestParam Integer tourId
//    ) {
//        Accounts accounts = new Accounts();
//        accounts.setFullName(fullName);
//        accounts.setUsername(email);
//        accounts.setPassword("1111");
//        accounts.setEmail(email);
//        accounts.setPhoneNumber(phoneNumber);
//        accountService.saveAccount(accounts);
//    }

}
