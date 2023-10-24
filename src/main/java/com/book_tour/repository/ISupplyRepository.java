package com.book_tour.repository;

import com.book_tour.model.Supply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISupplyRepository extends JpaRepository<Supply,Long> {
}
