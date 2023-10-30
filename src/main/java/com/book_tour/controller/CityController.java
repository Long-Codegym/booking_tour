package com.book_tour.controller;

import com.book_tour.model.City;
import com.book_tour.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    ICityService iCityService;
    @GetMapping("/{nameZone}")
    public ResponseEntity<List<City>> getAllCityByZone(@PathVariable String nameZone){
        return new ResponseEntity<>(iCityService.getAllCityByZone(nameZone), HttpStatus.OK);
    }
}
