package vudinhdo.web.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vudinhdo.web.travel.model.Tours;

@Repository
public interface TourRepository extends JpaRepository<Tours, Integer> {
}
