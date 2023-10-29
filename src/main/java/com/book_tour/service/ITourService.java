package com.book_tour.service;

import com.book_tour.model.Tour;

import java.util.List;

public interface ITourService extends ICrudService<Tour>{
    List<Tour> findPopularToursInCurrentMonth();
    List<Tour> getAllTourByZone(String zone);
    Tour getTourById(long idTour);
}
