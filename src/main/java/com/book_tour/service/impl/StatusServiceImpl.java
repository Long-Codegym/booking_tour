package com.book_tour.service.impl;

import com.book_tour.model.Status;
import com.book_tour.repository.IStatusRepository;
import com.book_tour.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StatusServiceImpl implements IStatusService {
    @Autowired
    IStatusRepository iStatusRepository;
    @Override
    public List<Status> getAll() {
        return iStatusRepository.findAll();
    }

    @Override
    public Status getById(long id) {
        return null;
    }

    @Override
    public Status create(Status status) {
        return null;
    }

    @Override
    public Status edit(Status status) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }
}
