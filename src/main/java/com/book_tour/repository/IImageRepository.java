package com.book_tour.repository;

import com.book_tour.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageRepository extends JpaRepository<Image,Long> {
}
