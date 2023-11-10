package com.book_tour.service;

import com.book_tour.model.Tour;
import com.book_tour.model.dto.FilterTour;
import com.book_tour.model.dto.TourDTO;

import java.util.List;

public interface ITourService extends ICrudService<Tour>{
    List<Tour> findPopularToursInCurrentMonth();
    List<TourDTO> getAllTourByZone(String zone);
    TourDTO getTourById(long idTour);
    List<TourDTO> getAllTourByFilter(FilterTour filterTour);
    List<TourDTO> getAllTourByIdAcc(long idAcc);

}
