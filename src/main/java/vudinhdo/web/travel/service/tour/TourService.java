package vudinhdo.web.travel.service.tour;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vudinhdo.web.travel.model.Tours;
import vudinhdo.web.travel.repository.TourRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TourService implements TourServiceIMPL {
    @Autowired
    private TourRepository tourRepository;

    /**
     * @return
     */
    @Override
    public List<Tours> getAllTour() {
        return tourRepository.findAll();
    }

    /**
     * @param saveTour
     * @return
     */
    @Override
    public Tours saveTour(Tours saveTour) {
        return tourRepository.save(saveTour);
    }

    /**
     * @param idTour
     * @return
     */
    @Override
    public Tours findTourById(int idTour) {
        Optional<Tours> toursOptional = tourRepository.findById(idTour);
        return  toursOptional.orElse(null);
    }
}
