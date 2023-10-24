package com.book_tour.controller;

import com.book_tour.model.Tour;
import com.book_tour.service.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/tours")
public class TourController {
    @Autowired
    ITourService iTourService;

    @GetMapping("/allTour")
    public ResponseEntity<List<Tour>> getAllTour() {
        return new ResponseEntity<>(iTourService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id_Tour}")
    public ResponseEntity<Tour> getTourByID(@PathVariable long id_Tour) {
        return new ResponseEntity<>(iTourService.getById(id_Tour), HttpStatus.OK);
    }
    @GetMapping
}
