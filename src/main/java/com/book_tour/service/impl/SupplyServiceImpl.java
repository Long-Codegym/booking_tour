package com.book_tour.service.impl;

import com.book_tour.model.Supply;
import com.book_tour.repository.ISupplyRepository;
import com.book_tour.service.ISupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SupplyServiceImpl implements ISupplyService {
    @Autowired
    ISupplyRepository iSupplyRepository;
    @Override
    public List<Supply> getAll() {
        List<Supply> supplies = iSupplyRepository.findAll();
        return supplies;
    }

    @Override
    public Supply getById(long id) {
        return null;
    }

    @Override
    public Supply create(Supply supply) {
        return null;
    }

    @Override
    public Supply edit(Supply supply) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }
}
