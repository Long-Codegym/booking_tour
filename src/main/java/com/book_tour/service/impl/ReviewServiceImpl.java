package com.book_tour.service.impl;

import com.book_tour.model.Bill;
import com.book_tour.model.Review;
import com.book_tour.repository.IReviewRepository;
import com.book_tour.service.IBillService;
import com.book_tour.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Service
public class ReviewServiceImpl implements IReviewService {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    IReviewRepository iReviewRepository;
    @Autowired
    IBillService iBillService;
    @Override
    public List<Review> getAll() {
        return null;
    }

    @Override
    public Review getById(long id) {
        return null;
    }

    @Override
    public Review create(Review review) {
        return iReviewRepository.save(review);
    }

    @Override
    public Review edit(Review review) {
        return iReviewRepository.save(review);
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public List<Review> getAllActiveByTourId(long tourId) {

        return iReviewRepository.getAllActiveByTourID(tourId);
    }

    @Override
    public Boolean isAbleToReview(Long tourId, Long userId) {
        Bill latestBill = iBillService.getLatestBillBy2Acc(tourId, userId);
        Review latestReview = getLatestReviewBy2Acc(tourId, userId);
        if (latestBill == null) {
            return false;
        } else if (latestReview == null) {
            return true;
        } else {
            return latestBill.getDateCreate().getTime() - latestReview.getDate().getTime() > 0;
        }
    }


    @Override
    public Review getLatestReviewBy2Acc(Long tourId, Long userId) {
        try {
            List<Review> results = entityManager.createQuery("select r from Review r " +
                            "where r.accountUser.id = :userId and r.tour.id = :tourId order by r.id desc ")
                    .setMaxResults(1)
                    .setParameter("tourId", tourId)
                    .setParameter("userId", userId)
                    .getResultList();
            return results.get(0);
        } catch (Exception e) {
            return null;
        }
    }
}
