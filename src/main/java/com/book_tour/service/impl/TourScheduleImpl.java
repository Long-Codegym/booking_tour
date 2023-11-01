package com.book_tour.service.impl;

import com.book_tour.model.TourSchedule;
import com.book_tour.repository.ITourScheduleRepository;
import com.book_tour.service.ITourScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourScheduleImpl implements ITourScheduleService {
    @Autowired
    ITourScheduleRepository iTourScheduleRepository;

    @Override
    public List<TourSchedule> getAll() {
        return null;
    }

    @Override
    public TourSchedule getById(long id) {
        return null;
    }

    @Override
    public TourSchedule create(TourSchedule tourSchedule) {
        TourSchedule tourSchedule1 = iTourScheduleRepository.save(tourSchedule);
        return tourSchedule1;
    }

    @Override
    public TourSchedule edit(TourSchedule tourSchedule) {
        return null;
    }

    @Override
    public void deleteById(long id) {
    }
}
