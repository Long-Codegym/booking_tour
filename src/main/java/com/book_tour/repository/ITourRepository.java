package com.book_tour.repository;

import com.book_tour.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITourRepository extends JpaRepository<Tour,Long> {
    @Query("SELECT t FROM Tour t " +
            "LEFT JOIN Bill b ON t.id = b.tour.id " +
            "WHERE MONTH(b.dateStart) = :month AND YEAR(b.dateStart) = :year " +
            "GROUP BY t.id " +
            "ORDER BY COUNT(b) DESC")
    List<Tour> findPopularToursInMonth(int month, int year);
    @Query(value = "select t FROM Tour t join City c on t.city.id = c.id join Zone z on c.zone.id = z.id where z.name = :nameZone")
    List<Tour> getAllTourByZone(@Param("nameZone") String nameZone);
}
