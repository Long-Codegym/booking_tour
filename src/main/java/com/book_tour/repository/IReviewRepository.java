package com.book_tour.repository;

import com.book_tour.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IReviewRepository extends JpaRepository<Review,Long> {
    @Query("select r from Review r " +
            "where r.tour.id = :tourId " +
            "and r.isActive = true order by r.id desc ")
    List<Review> getAllActiveByTourID(long tourId);
}
