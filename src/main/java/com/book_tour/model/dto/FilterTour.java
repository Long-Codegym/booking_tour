package com.book_tour.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FilterTour {
    private long idCity;
    private Long minPrice;
    private Long maxPrice;

    public FilterTour(long idCity, Long minPrice, Long maxPrice) {
        this.idCity = idCity;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }
}
