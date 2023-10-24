package com.book_tour.service.impl;

import com.book_tour.model.Message;
import com.book_tour.service.IMessageService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageServiceImpl implements IMessageService {
    @Override
    public List<Message> getAll() {
        return null;
    }

    @Override
    public Message getById(long id) {
        return null;
    }

    @Override
    public Message create(Message message) {
        return null;
    }

    @Override
    public Message edit(Message message) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }
}
