package com.book_tour.service;

import com.book_tour.model.Review;

import java.util.List;

public interface IReviewService extends ICrudService<Review>{
    List<Review> getAllActiveByTourId( long tourId);
    Boolean isAbleToReview(Long tourId, Long userId);
    Review getLatestReviewBy2Acc(Long tourId, Long userId);
}
