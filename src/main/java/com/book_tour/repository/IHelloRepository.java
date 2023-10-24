package com.book_tour.repository;

import com.book_tour.model.Hello;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHelloRepository extends JpaRepository<Hello,Long> {
}
