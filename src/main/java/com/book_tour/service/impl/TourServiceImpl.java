package com.book_tour.service.impl;

import com.book_tour.model.Tour;
import com.book_tour.repository.ITourRepository;
import com.book_tour.service.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourServiceImpl implements ITourService {
    @Autowired
    ITourRepository iTourService;
    @Override
    public List<Tour> getAll() {
        return iTourService.findAll();
    }

    @Override
    public Tour getById(long id) {
        return iTourService.getReferenceById(id);
    }

    @Override
    public Tour create(Tour tour) {
        return iTourService.save(tour);
    }

    @Override
    public Tour edit(Tour tour) {
        return iTourService.save(tour);
    }

    @Override
    public void deleteById(long id) {
        iTourService.delete(iTourService.getReferenceById(id));
    }
}
