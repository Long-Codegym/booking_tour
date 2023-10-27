package com.book_tour.repository;

import com.book_tour.model.Zone;
import com.book_tour.model.dto.ZoneDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IZoneRepository extends JpaRepository<Zone,Long> {
    @Query("SELECT new com.book_tour.model.dto.ZoneDTO(z, COUNT(t)) " +
            "FROM Zone z " +
            "LEFT JOIN City c on z.id = c.zone.id join Tour t on c.id = t.city.id GROUP BY z")
    List<ZoneDTO> getZoneTourCounts();
}
