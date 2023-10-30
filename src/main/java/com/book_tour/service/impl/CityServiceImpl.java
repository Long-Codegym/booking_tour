package com.book_tour.service.impl;

import com.book_tour.model.City;
import com.book_tour.repository.ICityRepository;
import com.book_tour.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityServiceImpl implements ICityService {
    @Autowired
    ICityRepository iCityRepository;
    @Override
    public List<City> getAll() {
        return null;
    }

    @Override
    public City getById(long id) {
        return null;
    }

    @Override
    public City create(City city) {
        return null;
    }

    @Override
    public City edit(City city) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public List<City> getAllCityByZone(String nameZone) {
        List<City> cityList = iCityRepository.getAllCityByZone(nameZone);
        return cityList;
    }
}
