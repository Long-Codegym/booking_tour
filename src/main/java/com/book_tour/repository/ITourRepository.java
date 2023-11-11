package com.book_tour.repository;

import com.book_tour.model.Tour;
import com.book_tour.model.dto.TourDTO;
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
//    @Query(value = "select t FROM Tour t join City c on t.city.id = c.id join Zone z on c.zone.id = z.id where z.name = :nameZone")
//    List<Tour> getAllTourByZone(@Param("nameZone") String nameZone);
    @Query(value = "select new com.book_tour.model.dto.TourDTO(t,avg(rev.rating),count(rev.rating))" +
            "from Tour t left join Review rev on rev.tour.id = t.id" +
            " join City c on t.city.id = c.id join Zone z on c.zone.id = z.id where z.name = :nameZone  group by t.id order by t.id desc ")
    List<TourDTO> getAllTourByZone(@Param("nameZone")String nameZone);
    @Query(value = "select new com.book_tour.model.dto.TourDTO(t,avg(rev.rating),count(rev.rating))" +
            "from Tour t left join Review rev on rev.tour.id = t.id" +
            " join City c on t.city.id = c.id join Zone z on c.zone.id = z.id where t.id = :idTour group by t.id")
    TourDTO getTourDTObyId(@Param("idTour") long idTour);
    @Query(value = "select new com.book_tour.model.dto.TourDTO(t, avg(rev.rating), count(rev.rating)) " +
            "from Tour t " +
            "left join Review rev on rev.tour.id = t.id " +
            "join City c on t.city.id = c.id " +
            "join Zone z on c.zone.id = z.id " +
            "where (:idCity is null or c.id = :idCity) " +
            "and (:minPrice is null AND :maxPrice is null) or (t.price >= :minPrice AND t.price <= :maxPrice)  " +
            "or ((t.price >= :minPrice AND :maxPrice is null) or (:minPrice is null AND t.price <= :maxPrice)) " +
            "and z.name = :nameZone " +
            "group by t.id " +
            "order by  t.id desc ")
    List<TourDTO> getAllTourByFilter(
            @Param("idCity")Long idCity,
            @Param("nameZone")String nameZone,
            @Param("minPrice")Long minPrice,
            @Param("maxPrice")Long maxPrice);

    @Query(value = "select new com.book_tour.model.dto.TourDTO(t,avg(rev.rating),count(rev.rating))" +
            "from Tour t left join Review rev on rev.tour.id = t.id" +
            " join City c on t.city.id = c.id join Zone z on c.zone.id = z.id where t.account.id = :idAcc group by t.id order by  t.id desc ")
    List<TourDTO> getTourDTObyIdAcc(@Param("idAcc") long idAcc);
}
