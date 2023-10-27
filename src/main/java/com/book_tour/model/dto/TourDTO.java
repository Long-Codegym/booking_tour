package com.book_tour.model.dto;

import com.book_tour.model.Image;
import com.book_tour.model.Tour;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
@Data
@AllArgsConstructor
public class TourDTO {
    Tour tour;
    List<Image> image;
}
