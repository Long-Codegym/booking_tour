package com.book_tour.model.dto;

import com.book_tour.model.Zone;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ZoneDTO {
    private Zone zone;
    private long tourNumber;

    public ZoneDTO(Zone zone, long tourNumber) {
        this.zone = zone;
        this.tourNumber = tourNumber;
    }
}
