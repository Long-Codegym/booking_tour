package com.book_tour.repository;

import com.book_tour.model.TourSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITourScheduleRepository extends JpaRepository<TourSchedule,Long> {
}
