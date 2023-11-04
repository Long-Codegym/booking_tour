package com.book_tour.model.dto;

import com.book_tour.model.Image;
import com.book_tour.model.Tour;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Data
public class TourDTO {
    Tour tour;
    List<Image> image;
    private Double rate;
    private Long countRate;

    public TourDTO(Tour tour, List<Image> image, Double rate, Long countRate) {
        this.tour = tour;
        this.image = image ;
        this.rate = rate;
        this.countRate = countRate;
    }

    public TourDTO(Tour tour, Double rate, Long countRate) {
        this.tour = tour;
        this.rate = rate;
        this.countRate = countRate;
    }
}
