package com.book_tour.service.impl;

import com.book_tour.model.Tour;
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
        return iTourRepository.findAll();
    }

    @Override
    public Tour getById(long id) {
        return iTourRepository.findTourByIdIs(id);
    }

    @Override
    public Tour create(Tour tour) {
        return iTourRepository.save(tour);
    }

    @Override
    public Tour edit(Tour tour) {
        return iTourRepository.save(tour);
    }

    @Override
    public void deleteById(long id) {
        iTourRepository.deleteById(id);

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
    public List<Tour> getAllTourByZone(String zone) {
        List<Tour> tourList = iTourRepository.getAllTourByZone(zone);
        return tourList;
    }

    @Override
    public Tour getTourById(long idTour) {
        Tour tour = iTourRepository.findById(idTour).get();
        return tour;
    }
}
