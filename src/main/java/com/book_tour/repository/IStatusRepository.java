package com.book_tour.repository;

import com.book_tour.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatusRepository extends JpaRepository<Status,Long> {
}
