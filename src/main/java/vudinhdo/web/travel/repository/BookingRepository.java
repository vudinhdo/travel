package vudinhdo.web.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vudinhdo.web.travel.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer > {
}
