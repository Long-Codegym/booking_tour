package com.book_tour.controller;

import com.book_tour.model.Review;
import com.book_tour.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    IReviewService iReviewService;
    @GetMapping("/allActiveByTourId/{tourId}")
    ResponseEntity<List<Review>> getAllActiveByAccountCCDV_Username_Desc(@PathVariable long tourId) {
        return new ResponseEntity<>(iReviewService.getAllActiveByTourId(tourId), HttpStatus.OK);
    }

    @GetMapping("/isAbleToReview")
    ResponseEntity<Boolean> isAbleToReview(@RequestParam long tourId, @RequestParam long userId) {
        return new ResponseEntity<>(iReviewService.isAbleToReview(tourId, userId), HttpStatus.OK);
    }

    @PostMapping("/sendReview")
    ResponseEntity<Review> sendReview(@RequestBody Review review) {
        review.setDate(new Date());
        review.setIsActive(true);
        return new ResponseEntity<>(iReviewService.create(review), HttpStatus.OK);
    }
}
