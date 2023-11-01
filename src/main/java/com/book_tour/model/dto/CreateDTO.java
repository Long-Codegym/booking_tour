package com.book_tour.model.dto;

import com.book_tour.model.Tour;
import com.book_tour.model.TourSchedule;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CreateDTO {
    Tour tour;
    List<TourSchedule> tourSchedules;

    public CreateDTO(Tour tour, List<TourSchedule> tourSchedules) {
        this.tour = tour;
        this.tourSchedules = tourSchedules;
    }
}
