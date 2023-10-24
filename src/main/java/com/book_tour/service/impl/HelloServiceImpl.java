package com.book_tour.service.impl;

import com.book_tour.model.Hello;
import com.book_tour.service.IHelloService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HelloServiceImpl implements IHelloService {
    @Override
    public List<Hello> getAll() {
        return null;
    }

    @Override
    public Hello getById(long id) {
        return null;
    }

    @Override
    public Hello create(Hello hello) {
        return null;
    }

    @Override
    public Hello edit(Hello hello) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }
}
