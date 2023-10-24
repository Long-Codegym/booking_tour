package com.book_tour.repository;

import com.book_tour.model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILikesRepository extends JpaRepository<Likes,Long> {
}
