package com.book_tour.controller;

import com.book_tour.model.Image;
import com.book_tour.model.Tour;
import com.book_tour.model.dto.FilterTour;
import com.book_tour.model.dto.TourDTO;
import com.book_tour.service.IImageService;
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
    @Autowired
    IImageService iImageService;

    @GetMapping
    public ResponseEntity<List<Tour>> getTourFeaturedThisMonth() {
        return new ResponseEntity<>(iTourService.findPopularToursInCurrentMonth(), HttpStatus.OK);
    }

    @GetMapping("/getTourByZone/{nameZone}")
    public ResponseEntity<List<TourDTO>> getAllTourByZone(@PathVariable String nameZone) {
        List<TourDTO> tourDTOList = iTourService.getAllTourByZone(nameZone);
        return new ResponseEntity<>(tourDTOList, HttpStatus.OK);
    }

    @GetMapping("/getTourById/{idTour}")
    public ResponseEntity<TourDTO> getTourById(@PathVariable long idTour) {
        TourDTO tourDTO1 = iTourService.getTourById(idTour);
        List<Image> imageList = iImageService.getImageByTour(idTour);
        TourDTO tourDTO = new TourDTO(tourDTO1.getTour(),imageList,tourDTO1.getRate(),tourDTO1.getCountRate());
        return new ResponseEntity<>(tourDTO, HttpStatus.OK);
    }
    @PostMapping("/getAllTourByFilter")
    public ResponseEntity<List<TourDTO>> getAllTourByFilter(@RequestBody FilterTour filterTour){
        return new ResponseEntity<>(iTourService.getAllTourByFilter(filterTour),HttpStatus.OK);
    }
}
