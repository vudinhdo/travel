package vudinhdo.web.travel.service.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vudinhdo.web.travel.model.Cities;
import vudinhdo.web.travel.repository.CityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CityService implements CityServiceIMPL {

    @Autowired
    private CityRepository cityRepository;

    /**
     * @return
     */
    @Override
    public List<Cities> getAllCity() {
        return cityRepository.findAll();
    }

    /**
     * @param saveCity
     * @return
     */
    @Override
    public Cities saveCity(Cities saveCity) {
        return cityRepository.save(saveCity);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Cities> findCityById(Integer id) {
        return cityRepository.findById(id);
    }
}
