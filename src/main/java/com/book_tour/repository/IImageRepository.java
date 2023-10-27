package com.book_tour.repository;

import com.book_tour.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IImageRepository extends JpaRepository<Image,Long> {
    @Query(value = "select i from Image i where i.Tour.id = :idTour")
    List<Image>getImageByTour(@Param("idTour") long idTour);
}
