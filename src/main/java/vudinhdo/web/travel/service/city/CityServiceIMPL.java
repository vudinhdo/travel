package vudinhdo.web.travel.service.city;

import vudinhdo.web.travel.model.Cities;

import java.util.List;
import java.util.Optional;

public interface CityServiceIMPL {
    List<Cities> getAllCity();

    Cities saveCity(Cities saveCity);

    Optional<Cities> findCityById(Integer id);
}
