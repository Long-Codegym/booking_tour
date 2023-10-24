package com.book_tour.repository;

import com.book_tour.model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IZoneRepository extends JpaRepository<Zone,Long> {
}
