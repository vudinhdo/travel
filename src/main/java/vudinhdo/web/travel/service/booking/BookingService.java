package vudinhdo.web.travel.service.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vudinhdo.web.travel.model.Booking;
import vudinhdo.web.travel.repository.BookingRepository;

import java.util.List;
@Service
public class BookingService implements BookingServiceIMPL{

    @Autowired
    private BookingRepository bookingRepository;
    /**
     * @return
     */
    @Override
    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }
}
