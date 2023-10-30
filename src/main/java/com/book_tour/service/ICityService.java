package com.book_tour.service;

import com.book_tour.model.City;

import java.util.List;

public interface ICityService extends ICrudService<City>{
    List<City> getAllCityByZone(String nameZone);
}
