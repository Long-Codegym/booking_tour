package com.book_tour.service;

import com.book_tour.model.TourSchedule;

import java.util.List;

public interface ITourScheduleService extends ICrudService<TourSchedule>{
    List<TourSchedule> saveAll(List<TourSchedule> tourSchedules);
}
