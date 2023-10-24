package com.book_tour.repository;

import com.book_tour.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMessageRepository extends JpaRepository<Message,Long> {
}
