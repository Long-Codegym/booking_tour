package com.book_tour.service.impl;

import com.book_tour.model.Tour;
import com.book_tour.model.dto.FilterTour;
import com.book_tour.model.dto.TourDTO;
import com.book_tour.repository.ITourRepository;
import com.book_tour.service.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TourServiceImpl implements ITourService {
    @Autowired
    ITourRepository iTourRepository;
    @Override
    public List<Tour> getAll() {
        return null;
    }

    @Override
    public Tour getById(long id) {
        return null;
    }

    @Override
    public Tour create(Tour tour) {
        return null;
    }

    @Override
    public Tour edit(Tour tour) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public List<Tour> findPopularToursInCurrentMonth() {
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();

        List<Tour> popularToursData = iTourRepository.findPopularToursInMonth(currentMonth, currentYear);
        return popularToursData;
    }

    @Override
    public List<TourDTO> getAllTourByZone(String zone) {
        List<TourDTO> tourDTOList = iTourRepository.getAllTourByZone(zone);
        return tourDTOList;
    }

    @Override
    public TourDTO getTourById(long idTour) {
        TourDTO tourDTO = iTourRepository.getTourDTObyId(idTour);
        return tourDTO;
    }

    @Override
    public List<TourDTO> getAllTourByFilter(FilterTour filterTour) {
        Long idCity = filterTour.getIdCity();
        Long minPrice = filterTour.getMinPrice();
        Long maxPrice = filterTour.getMaxPrice();
        List<TourDTO> tourDTOList = iTourRepository.getAllTourByFilter(idCity,minPrice,maxPrice);
        return tourDTOList;
    }
}
