package com.book_tour.service;

import com.book_tour.model.Likes;
import com.book_tour.model.Zone;
import com.book_tour.model.dto.ZoneDTO;

import java.util.List;

public interface IZoneService extends ICrudService<Zone>{
    List<ZoneDTO> findZonesAndTourCount();
}
