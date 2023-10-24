package com.book_tour.repository;

import com.book_tour.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReviewRepository extends JpaRepository<Review,Long> {
}
