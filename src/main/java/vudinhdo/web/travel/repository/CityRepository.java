package vudinhdo.web.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vudinhdo.web.travel.model.Cities;

@Repository
public interface CityRepository extends JpaRepository<Cities,Integer> {
}
