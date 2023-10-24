package com.book_tour.repository;

import com.book_tour.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITourRepository extends JpaRepository<Tour,Long> {
}
