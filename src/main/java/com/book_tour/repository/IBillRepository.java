package com.book_tour.repository;

import com.book_tour.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBillRepository extends JpaRepository<Bill,Long> {
}
