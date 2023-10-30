package com.book_tour.repository;

import com.book_tour.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICityRepository extends JpaRepository<City,Long> {
    @Query(value = "select c from City c join Zone z on c.zone.id = z.id where z.name = :nameZone")
    List<City> getAllCityByZone(@Param("nameZone")String nameZone);
}
