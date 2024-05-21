package vudinhdo.web.travel.service.tour;

import vudinhdo.web.travel.model.Tours;

import java.util.List;

public interface TourServiceIMPL {
    List<Tours> getAllTour();

    Tours saveTour(Tours saveTour);
}
